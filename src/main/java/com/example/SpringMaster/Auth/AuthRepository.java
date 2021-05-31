package com.example.SpringMaster.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Auth - DATA ACCESS Layer
@Repository
public interface AuthRepository
        extends JpaRepository<Auth, Long> {
}