package com.example.SpringMaster.Admin;

import com.example.SpringMaster.Auth.Auth;
import com.example.SpringMaster.Usage.Usage;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Admin - Class
@Entity(name = "Admin")
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

//    @NotBlank(message = "Full Name must be not empty")
    private String fullName;

//    @NotBlank(message = "Email must be not empty")
    @Email // Email Validation
    @Column(unique = true)
    private String email;

    private LocalDate dob;
    private String mobileNumber;

//    @NotBlank(message = "Password must be not empty")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Allows sending password and not reading it
    private String password;

    // TODO R/S USAGE: ONE Admin, MANY Usages
    @OneToMany(mappedBy = "adminUsage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "usage-admin")
    private List<Usage> usages = new ArrayList<>();

    // TODO R/S AUTH: ONE Admin, Many Auths
    @OneToMany(mappedBy = "adminAuthorizer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "auth-admin")
    private List<Auth> authorization = new ArrayList<>();

    // TODO R/S ADMIN: an Admin can be authorised by many Admins, an Admin can authorize many Admins
    @ManyToMany
    @JoinTable( // creates new table
            name="admin_authorised",
            joinColumns = @JoinColumn(name="admin_authorised_id"),
            inverseJoinColumns = @JoinColumn(name="admin_authoriser_id")
    )
    private Set<Admin> adminAllow = new HashSet<>();

    // Mapping for unary
    @JsonIgnore
    @ManyToMany(mappedBy = "adminAllow")
    private Set<Admin> adminAllowed = new HashSet<>();

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

    public String getPassword() {
        return password;
    }

    public List<Usage> getUsages() {
        return usages;
    }

    public List<Auth> getAuthorization() {
        return authorization;
    }

    public Set<Admin> getAdminAllow() {
        return adminAllow;
    }

    public Set<Admin> getAdminAllowed() {
        return adminAllowed;
    }
}

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

// // Admin ToString
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