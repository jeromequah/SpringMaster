package com.example.SpringMaster.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("GET REQUEST...");
        return adminService.getAdmin();
    }

    @PostMapping
    void createNewAdmin(@RequestBody Admin admin) {
        System.out.println("POST REQUEST...");
        System.out.println(admin);
    }

    @PutMapping
    void updateAdmin(@RequestBody Admin admin) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(admin);
    }

    @DeleteMapping(path = "{adminId}")
    void deleteAdmin(@PathVariable("adminId") Long id) {
        System.out.println("DELETE REQUEST...");
    }
}
