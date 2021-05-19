package com.example.SpringMaster.Admin;

import com.example.SpringMaster.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Admin - REST Layer
@RequestMapping(path = "api/v1/admins")
@RestController

// lombok
@AllArgsConstructor

public class AdminController {

    private final AdminService adminService; // immutability

//    // AdminService Constructor
//    @Autowired // Injects adminService to AdminController
//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }

    // GET All Admin Details
    @GetMapping(path = "allAdmin")
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    // GET SINGLE Admin Details
    @GetMapping(path = "getAdminDetails")
    public Admin getAdmin(@Param("email") String email) {
        return adminService.getAdmin(email);
    }

    // GET SINGLE Admin Details Exception
    @GetMapping(path = "{adminId}/exception")
    Admin getAdminException(@PathVariable("adminId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for Admin " + id
        );
    }

    @PostMapping(path = "createAdmin")
    public void createAdmin(@Valid // Invokes NotBlank for Admin Class
                     @RequestBody Admin admin) {
        adminService.createAdmin(admin);
    }

    @PutMapping(path = "update")
    public void updateAdmin(@RequestBody Admin admin) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(admin);
    }

    @DeleteMapping(path = "delete/{adminId}")
    public void deleteAdmin(@PathVariable("adminId") Long adminId) {
        adminService.deleteAdmin(adminId);
    }
}
