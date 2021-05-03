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
@Repository // Spring creates new instance of AdminRepository
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
