package com.example.SpringMaster.Admin;

import com.example.SpringMaster.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.common.util.impl.Log_$logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        if (admin!=null) {
            return admin;
        } else {
            return new Admin();
        }
    }

    Admin createAdmin(Admin newAdmin) {
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


