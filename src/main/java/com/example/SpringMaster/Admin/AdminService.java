package com.example.SpringMaster.Admin;

import com.example.SpringMaster.exception.NotFoundException;
import org.hibernate.annotations.common.util.impl.Log_$logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// Admin - SERVICE Layer (Business Logic)

@Component // creates a Bean to inject in multiple places with the SAME instance
public class AdminService {

    //    Logging for AdminService Class
    private final static Logger LOGGER = // must be the Interface slf4j
            LoggerFactory.getLogger(AdminService.class);

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
        LOGGER.info("getAdmins called");
        return adminRepository.findAll();
    }

    Admin getAdmin(String email) {
        return adminRepository.findByEmail(email);
    }

    Admin createAdmin(Admin newAdmin) {
        // TODO post new admin to postgres DB
        adminRepository.save(newAdmin);
        return newAdmin;
    }
}
//                .orElseThrow(
//                        () -> {
//                            NotFoundException notFoundException = new NotFoundException(
//                                    "Admin with id " + id + " Not Found");
//                            LOGGER.error("Error for admin {}", id, notFoundException);
//                            return notFoundException;


