package com.dqm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dqm.entity.Organization;
import com.dqm.exception.ResourceNotFoundException;
import com.dqm.repository.OrganizationRepository;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Organization getOrganizationById(Long id) {

    return organizationRepository.findById(id)
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Organization not found with id : " + id
                    ));
}

    public Organization updateOrganization(Long id, Organization organization) {
        organization.setOrganizationId(id);
        return organizationRepository.save(organization);
    }

    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}