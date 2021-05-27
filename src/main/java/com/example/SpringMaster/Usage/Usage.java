package com.example.SpringMaster.Usage;

import com.example.SpringMaster.Admin.Admin;
import com.example.SpringMaster.Lock.Lock;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

// Usage - Class
@Entity(name = "Usage")
@Table

// lombok
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Usage {
    // Class Properties

    @Id
    @SequenceGenerator(
            name = "usage_sequence",
            sequenceName = "usage_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usage_sequence"
    )
    private long id;

    // DateTimestamp Unlock
    private LocalDateTime datetimeUnlocked;

    // TODO R/S ADMIN: MANY Usages, ONE Admin
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "admin_id",
            nullable = true,
            referencedColumnName = "id"
    )
    private Admin adminUsage;

    // TODO R/S Lock: MANY Usages, ONE Lock
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "lock_id",
            nullable = true,
            referencedColumnName = "id"
    )
    private Lock lock;

    // Usage - Getters
    public long getId() {
        return id;
    }

    public LocalDateTime getDatetimeUnlocked() {
        return datetimeUnlocked;
    }

    public Admin getAdminUsage() {
        return adminUsage;
    }

    public Lock getLock() {
        return lock;
    }
}
