package com.dqm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dqm.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}