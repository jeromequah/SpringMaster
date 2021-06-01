package com.example.SpringMaster.Usage;

import com.example.SpringMaster.Admin.Admin;
import com.example.SpringMaster.Lock.Lock;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private String datetimeUnlocked;

    // TODO R/S ADMIN: MANY Usages, ONE Admin
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Admin.class)
    @JoinColumn(
            name = "admin_id",
            nullable = true,
            referencedColumnName = "id"
    )
    @JsonBackReference(value = "usage-admin")
    private Admin adminUsage;

    // TODO R/S Lock: MANY Usages, ONE Lock
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Lock.class)
    @JoinColumn(
            name = "lock_id",
            nullable = true,
            referencedColumnName = "id"
    )
    @JsonBackReference(value = "usage-lock")
    private Lock lock;

    // Usage - Getters
    public long getId() {
        return id;
    }

    public String getDatetimeUnlocked() {
        return datetimeUnlocked;
    }

    public Admin getAdminUsage() {
        return adminUsage;
    }

    public Lock getLock() {
        return lock;
    }

    // TODO USAGE = Auto Set Timestamp Upon Creation instead of NULL
    public void setDatetimeUnlocked(String datetimeUnlocked) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.datetimeUnlocked = now.format(format);
    }
}