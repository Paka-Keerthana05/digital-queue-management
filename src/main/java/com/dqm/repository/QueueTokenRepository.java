package com.dqm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dqm.entity.QueueToken;

public interface QueueTokenRepository extends JpaRepository<QueueToken, Long> {

}