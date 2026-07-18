package com.dqm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dqm.entity.Counter;

public interface CounterRepository extends JpaRepository<Counter, Long> {

}