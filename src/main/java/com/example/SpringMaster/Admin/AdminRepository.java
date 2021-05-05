package com.example.SpringMaster.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Admin - DATA ACCESS Layer

// AdminRepository is used to connect to database
@Repository
public interface AdminRepository
        extends JpaRepository<Admin, Long> {
}
