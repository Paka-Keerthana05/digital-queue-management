package com.dqm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dqm.dto.CustomerRegistrationRequest;
import com.dqm.dto.LoginRequest;
import com.dqm.dto.LoginResponse;
import com.dqm.dto.UserResponse;
import com.dqm.entity.User;
import com.dqm.enums.Role;
import com.dqm.enums.UserStatus;
import com.dqm.exception.DuplicateResourceException;
import com.dqm.exception.InvalidCredentialsException;
import com.dqm.repository.UserRepository;
import com.dqm.security.JwtService;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // Customer Registration
    public UserResponse registerCustomer(CustomerRegistrationRequest request) {

        // Check if email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email already registered");
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());

        // Set values internally
        user.setRole(Role.CUSTOMER);
        user.setStatus(UserStatus.ACTIVE);

        User savedUser = userRepository.save(user);

        UserResponse response = new UserResponse();

        response.setUserId(savedUser.getUserId());
        response.setFullName(savedUser.getFullName());
        response.setEmail(savedUser.getEmail());
        response.setPhone(savedUser.getPhone());
        response.setRole(savedUser.getRole());
        response.setStatus(savedUser.getStatus());

        return response;
    }
    public LoginResponse login(LoginRequest request) {

        

        User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() ->
                new InvalidCredentialsException("Invalid email or password"));

        

        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        

        if (!passwordMatches) {
    throw new InvalidCredentialsException("Invalid email or password");
}

        LoginResponse response = new LoginResponse();

        response.setUserId(user.getUserId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setStatus(user.getStatus());
        String token = jwtService.generateToken(user.getEmail());
        response.setToken(token);
        return response;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by id
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}