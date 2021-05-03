package com.example.SpringMaster.Admin;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

// Admin - DATA ACCESS Layer

// AdminRepository is used to connect to database
@Repository
@Primary
public class AdminRepository implements AdminRepo {
    @Override
    public List<Admin> getAdmins() {
        // TODO connect to real db
        return Collections.emptyList();
    }
}
