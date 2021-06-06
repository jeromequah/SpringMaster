package com.example.SpringMaster.Auth;

import com.example.SpringMaster.Admin.Admin;
import com.example.SpringMaster.Lock.Lock;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;

// Auth - Class
@Entity(name = "Auth")
@Table

// lombok
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIdentityInfo( // Helps serialisation of entities with bidirectional R/S
        scope = Auth.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

public class Auth {
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
    private String datetimeAccepted;

    // TODO R/S ADMIN: MANY Auths, ONE Admin
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Admin.class)
    @JoinColumn(
            name = "authorizer_admin_id",
            nullable = true,
            referencedColumnName = "id"
    )
    @JsonBackReference(value = "auth-admin")
    private Admin adminAuthorizer;

    // TODO R/S LOCK: MANY Auths, ONE Lock
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Lock.class)
    @JoinColumn(
            name = "lock_id",
            nullable = true,
            referencedColumnName = "id"
    )
    @JsonBackReference(value = "auth-lock")
    private Lock lock;

    // AUTH - Getters
    public long getId() {
        return id;
    }

    public String getDatetimeAccepted() {
        return datetimeAccepted;
    }

    public Admin getAdminAuthorizer() {
        return adminAuthorizer;
    }

    public Lock getLock() {
        return lock;
    }
}
