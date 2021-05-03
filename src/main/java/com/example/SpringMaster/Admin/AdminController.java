package com.example.SpringMaster.Admin;

import com.example.SpringMaster.SpringMasterApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

// Admin - REST Layer
@RestController
public class AdminController {
    @GetMapping
    Admin getAdmin() {
        return new Admin(
                1,
                "Jerome Quah Wei Ren",
                "jeromequah123@msn.com",
                LocalDate.of(1997, Month.MARCH,28),
                "98765432",
                "password");
    }
}
