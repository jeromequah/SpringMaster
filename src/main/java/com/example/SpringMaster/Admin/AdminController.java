package com.example.SpringMaster.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Admin - REST Layer
@RestController
public class AdminController {

    private final AdminService adminService; // immutability

    // AdminService Constructor
    @Autowired // Injects adminService to AdminController
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    List<Admin> getAdmin() {
        return adminService.getAdmin();
    }
}
