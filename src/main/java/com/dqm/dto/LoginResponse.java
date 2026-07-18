package com.dqm.dto;

import com.dqm.enums.Role;
import com.dqm.enums.UserStatus;

public class LoginResponse {

    private Long userId;
    private String fullName;
    private String email;
    private Role role;
    private UserStatus status;
    private String token;

    public String getToken() {
    return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}