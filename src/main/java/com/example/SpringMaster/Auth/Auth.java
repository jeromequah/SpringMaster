package com.example.SpringMaster.Auth;


import com.example.SpringMaster.Admin.Admin;
import com.example.SpringMaster.Lock.Lock;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

// Auth - Class
@Entity(name = "Auth")
@Table

// lombok
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Auth {
    // Class Properties

    // Autogenerate ID
    // Class Properties

    // Autogenerate ID
    @Id
    @SequenceGenerator(
            name = "auth_sequence",
            sequenceName = "auth_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "auth_sequence"
    )
    private long id;

    // DateTimestamp
    private LocalDateTime datetimeAccepted;

    // TODO R/S ADMIN: MANY Auths, ONE Admin
    @ManyToOne
    @JoinColumn(
            name = "authorizer_admin_id",
            nullable = true,
            referencedColumnName = "id"
    )
    private Admin adminAuthorizer;

    // TODO R/S LOCK: MANY Auths, ONE Lock
    @ManyToOne
    @JoinColumn(
            name = "lock_id",
            nullable = true,
            referencedColumnName = "id"
    )
    private Lock lock;

    // AUTH - Getters
    public long getId() {
        return id;
    }

    public LocalDateTime getDatetimeAccepted() {
        return datetimeAccepted;
    }

    public Admin getAdminAuthorizer() {
        return adminAuthorizer;
    }

    public Lock getLock() {
        return lock;
    }
}
