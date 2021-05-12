package com.example.SpringMaster.Admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

// Admin - Class
@Entity
@Table

// lombok
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
// @Data used when fields are meant to be final, replaces everything
// @Entity @Table maps Admin class to H2 DB Table
public class Admin {
    // Class properties

    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    private long id;

    @NotBlank(message = "Full Name must be not empty") // Cannot be empty
    private String fullName;

    @NotBlank(message = "Email must be not empty")
    @Email // Email Validation
    private String email;

    private LocalDate dob;
    private String mobileNumber;

    @NotBlank(message = "Password must be not empty")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Allows sending password and not reading it
    private String password;

//    // Admin - Constructor
//    Admin(long id, String fullName, String email, LocalDate dob, String mobileNumber, String password) {
//        this.id = id;
//        this.fullName = fullName;
//        this.email = email;
//        this.dob = dob;
//        this.mobileNumber = mobileNumber;
//        this.password = password;
//    }
//
//    // Admin - Empty Constructor
//    public Admin() {
//    }

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

    // @JsonIgnore password will not be returned
    public String getPassword() {
        return password;
    }

//    @Override
//    public String toString() {
//        return "Admin{" +
//                "id=" + id +
//                ", fullName='" + fullName + '\'' +
//                ", email='" + email + '\'' +
//                ", dob=" + dob +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
