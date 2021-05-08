package com.example.SpringMaster.Admin;

import java.util.List;

// Admin - DATA ACCESS Layer - Interface
public interface AdminRepo {
    List<Admin> getAdmins();
}