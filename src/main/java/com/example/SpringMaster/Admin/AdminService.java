package com.example.SpringMaster.Admin;

import org.springframework.stereotype.Component;

import java.util.List;

// Admin - SERVICE Layer (Business Logic)

@Component // creates a Bean to inject in multiple places with the SAME instance
public class AdminService {

    // Reference to Admin - DATA ACCESS Layer via Interface
    private final AdminRepo adminRepo;

    // Constructor for Admin Repo
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    List<Admin> getAdmin() {
        return adminRepo.getAdmins();
    }
}
