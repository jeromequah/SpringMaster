package com.example.SpringMaster.Admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

// Admin - Class
public class Admin {
    // Class properties
    private final long id;
    @NotBlank // Cannot be empty
    private final String fullName;
    private final String email;
    private final LocalDate dob;
    private final String mobileNumber;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Allows sending password and not reading it
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
    // Admin - Getters

    @JsonProperty("adminId") // changes id label to customer ID
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

    @JsonIgnore // password will not be returned
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
