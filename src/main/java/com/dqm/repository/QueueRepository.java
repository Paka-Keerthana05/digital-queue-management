package com.dqm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dqm.entity.Queue;

public interface QueueRepository extends JpaRepository<Queue, Long> {

}