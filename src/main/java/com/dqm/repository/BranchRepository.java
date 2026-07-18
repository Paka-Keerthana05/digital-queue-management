package com.dqm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dqm.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}