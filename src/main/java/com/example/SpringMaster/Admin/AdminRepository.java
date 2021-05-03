package com.example.SpringMaster.Admin;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;

// Admin - DATA ACCESS Layer

// AdminRepository is used to connect to database
public class AdminRepository implements AdminRepo {
    @Override
    public List<Admin> getAdmins() {
        // TODO connect to real db
        return Collections.singletonList(
                new Admin(
                        1,
                        "TODO. Implemented real database",
                        "realdb@real.com",
                        LocalDate.of(9999, Month.MARCH,20),
                        "99990000",
                        "password")
        );
    }
}
