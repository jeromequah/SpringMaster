package com.example.SpringMaster.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// Admin - SERVICE Layer (Business Logic)

//@Component creates a Bean to inject in multiple places with the SAME instance
@Service // subset of @Component, more specific for class to be used as a Service
public class AdminService {

    // Reference to Admin - DATA ACCESS Layer via Interface
    private final AdminRepo adminRepo;

    // Constructor for Admin Repo
    @Autowired // Will return the @Primary Component
    public AdminService(
            //@Qualifier("fake") // @Qualifier allows selection of specific @Component of the same Class
                    AdminRepo adminRepo) { // getting the SAME instance a
        this.adminRepo = adminRepo;
    }

    List<Admin> getAdmin() {
        return adminRepo.getAdmins();
    }
}
