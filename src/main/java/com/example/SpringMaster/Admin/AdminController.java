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
    List<Admin> getAdmins() {
        System.out.println("GET REQUEST...");
        return adminService.getAdmins();
    }

    // GET SINGLE Admin Details
    @GetMapping(path = "getAdminDetails")
    Admin getAdmin(@Param("email") String email) {
        System.out.println("GET REQUEST...");
        return adminService.getAdmin(email);
    }

    // GET SINGLE Admin Details Exception
    @GetMapping(path = "{adminId}/exception")
    Admin getAdminException(@PathVariable("adminId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for Admin " + id
        );
    }

    @PostMapping(path = "createAdmin"
//            consumes = {
//                    MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_JSON_VALUE
//            },
//            produces = {
//            MediaType.APPLICATION_XML_VALUE,
//            MediaType.APPLICATION_JSON_VALUE
//    }
    )
    Admin createAdmin(@Valid // Invokes NotBlank for Admin Class
                      @RequestBody Admin admin) {
        System.out.println("POST REQUEST...");
        System.out.println(admin);
        return adminService.createAdmin(admin);
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
