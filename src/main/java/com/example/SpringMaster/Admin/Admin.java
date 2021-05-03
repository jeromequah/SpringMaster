package com.example.SpringMaster.Admin;

import java.time.LocalDate;

// Admin - Class
public class Admin {
    private final long id;
    private final String fullName;
    private final String email;
    private final LocalDate dob;
    private final String mobileNumber;
    private final String password;

    // Admin - Constructor
    Admin(long id, String fullName, String email, LocalDate dob, String mobileNumber, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }
    // Admin - Getter
    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
