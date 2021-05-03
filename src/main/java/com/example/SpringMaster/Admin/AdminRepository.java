package com.example.SpringMaster.Admin;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Admin - DATA ACCESS Layer

// AdminRepository is used to connect to database
@Component
@Primary // When @Autowired at SERVICE Layer, this Primary implementation will be used
public class AdminRepository implements AdminRepo {
    @Override
    public List<Admin> getAdmins() {
        // TODO connect to real db
        return Collections.singletonList(
                new Admin(
                        1,
                        "TODO. Implement real database",
                        "Implementrealdata@msn.com",
                        LocalDate.of(1997, Month.MARCH,28),
                        "98765432",
                        "password")
        );
    }
}
