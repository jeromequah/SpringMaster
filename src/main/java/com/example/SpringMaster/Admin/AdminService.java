package com.example.SpringMaster.Admin;

import com.example.SpringMaster.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

// Admin - SERVICE Layer (Business Logic)

@Component // creates a Bean to inject in multiple places with the SAME instance
public class AdminService {

    // Reference to Admin - DATA ACCESS Layer via Interface
    private final AdminRepo adminRepo;

    // Constructor for Admin Repo
    @Autowired
    public AdminService(
//            @Qualifier("fake") Annotation for using FakeRepository as its value = "fake"
                    AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    List<Admin> getAdmins() {
        return adminRepo.getAdmins();
    }

    Admin getAdmin(Long id) {
        return getAdmins()
                .stream().filter(admin -> admin.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Admin with id " + id + " Not Found"));
    }
}
