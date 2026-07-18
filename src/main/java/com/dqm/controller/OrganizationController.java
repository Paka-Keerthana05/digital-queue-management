package com.dqm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dqm.dto.ApiResponse;
import com.dqm.entity.Organization;
import com.dqm.service.OrganizationService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/organizations")
@CrossOrigin("*")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    // Create Organization
    @PostMapping
    public Organization saveOrganization(@Valid @RequestBody Organization organization) {
        return organizationService.saveOrganization(organization);
    }
    // Get All Organizations
    @GetMapping
    public List<Organization> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    // Get Organization By ID
    @GetMapping("/{id}")
    public ApiResponse<Organization> getOrganizationById(@PathVariable Long id) {

        Organization organization = organizationService.getOrganizationById(id);

        return new ApiResponse<>(
                true,
                "Organization fetched successfully",
                organization
        );
    }

    // Update Organization
    @PutMapping("/{id}")
    public Organization updateOrganization(@PathVariable Long id,
                                           @RequestBody Organization organization) {
        return organizationService.updateOrganization(id, organization);
    }

    // Delete Organization
    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }
}