package com.example.SpringMaster.Admin;

import com.example.SpringMaster.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Admin - REST Layer
@RequestMapping(path = "api/v1/admins")
@RestController
public class AdminController {

    private final AdminService adminService; // immutability

    // AdminService Constructor
    @Autowired // Injects adminService to AdminController
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // GET All Admin Details
    @GetMapping
    List<Admin> getAdmins() {
        System.out.println("GET REQUEST...");
        return adminService.getAdmins();
    }

    // GET SINGLE Admin Details
    @GetMapping(path ="{adminEmail}")
    Admin getAdmin(@PathVariable("adminEmail") String email) {
        System.out.println("GET REQUEST...");
        return adminService.getAdmin(email);
    }

    // GET SINGLE Admin Details Exception
    @GetMapping(path ="{adminId}/exception")
    Admin getAdminException(@PathVariable("adminId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for Admin " + id
        );
    }

    @PostMapping(path = "post")
    void createNewAdmin(@Valid // Invokes NotBlank for Admin Class
                        @RequestBody Admin admin) {
        System.out.println("POST REQUEST...");
        System.out.println(admin);
    }

    @PutMapping(path = "update")
    void updateAdmin(@RequestBody Admin admin) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(admin);
    }

    @DeleteMapping(path = "delete/{adminId}")
    void deleteAdmin(@PathVariable("adminId") Long id) {
        System.out.println("DELETE REQUEST WITH ADMIN ID = " + id);
    }
}
