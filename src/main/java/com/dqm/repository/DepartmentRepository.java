package com.dqm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dqm.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}