package com.example.SpringMaster.Admin;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

// Admin - SERVICE Layer (Business Logic)

@Component // creates a Bean to inject in multiple places with the SAME instance

// lombok
@AllArgsConstructor
@Slf4j

public class AdminService {

//    //    Logging for AdminService Class
//    private final static Logger LOGGER = // must be the Interface slf4j
//            LoggerFactory.getLogger(AdminService.class);

    // Reference to Admin - DATA ACCESS Layer via Interface
    private final AdminRepository adminRepository;

//    // Constructor for Admin Repo
//    @Autowired
//    public AdminService(
////            @Qualifier("fake") Annotation for using FakeRepository as its value = "fake"
//            AdminRepository adminRepository) {
//        this.adminRepository = adminRepository;
//    }

    List<Admin> getAdmins() {
        log.info("getAdmins called");
        return adminRepository.findAll();
    }

    Admin getAdmin(String email) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            return admin;
        } else {
            return new Admin();
        }
    }

    Admin createAdmin(Admin newAdmin) {
        // TODO check if admin exists
        adminRepository.save(newAdmin);
        return newAdmin;
    }
}
//                .orElseThrow(
//                        () -> {
//                            NotFoundException notFoundException = new NotFoundException(
//                                    "Admin with id " + id + " Not Found");
//                            log.error("Error for admin {}", id, notFoundException);
//                            return notFoundException;


