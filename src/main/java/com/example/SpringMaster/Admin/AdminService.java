package com.example.SpringMaster.Admin;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

// Admin - SERVICE Layer (Business Logic)

@Component // creates a Bean to inject in multiple places with the SAME instance
public class AdminService {
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
