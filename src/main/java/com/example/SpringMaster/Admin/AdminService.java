package com.example.SpringMaster.Admin;

import com.example.SpringMaster.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// Admin - SERVICE Layer (Business Logic)

@Component // creates a Bean to inject in multiple places with the SAME instance
public class AdminService {

    // Reference to Admin - DATA ACCESS Layer via Interface
    private final AdminRepository adminRepository;

    // Constructor for Admin Repo
    @Autowired
    public AdminService(
//            @Qualifier("fake") Annotation for using FakeRepository as its value = "fake"
                    AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    Admin getAdmin(Long id) {
        return adminRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Admin with id " + id + " Not Found"));
    }
}
