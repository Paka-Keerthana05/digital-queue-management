package com.dqm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dqm.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}