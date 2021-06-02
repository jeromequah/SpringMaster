package com.example.SpringMaster.Lock;

import com.example.SpringMaster.Auth.Auth;
import com.example.SpringMaster.Usage.Usage;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

// Lock - Class
@Entity(name = "Lock")
@Table

// lombok
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Lock {
    // Class Properties

    // Autogenerate ID
    @Id
    @SequenceGenerator(
            name = "lock_sequence",
            sequenceName = "lock_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lock_sequence"
    )
    private long id;

    // Customizable Label E.g. Lock Location
    @NotBlank
    private String lockNickName;

    // Assume BluetoothDevice.deviceName for FE
    @NotBlank
    @Column(nullable = false, unique = false)
    private String lockName;

    @NotBlank
    @Column(nullable = false, unique = false)
    // Assume BluetoothDevice.deviceAddress
    private String lockMacAddress;

    @NotBlank
    // Unlocked or Locked
    private String lockStatus;

    // TODO R/S USAGE: ONE Lock, MANY Usages
    @OneToMany(mappedBy = "lock", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "usage-lock")
    private List<Usage> usages = new ArrayList<>();

    // TODO R/S AUTH: ONE Lock, MANY Auths
    @OneToMany(mappedBy = "lock", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "auth-lock")
    private List<Auth> auths = new ArrayList<>();

    // Lock - Getters
    public long getId() {
        return id;
    }

    public String getLockNickName() {
        return lockNickName;
    }

    public String getLockName() {
        return lockName;
    }

    public String getLockMacAddress() {
        return lockMacAddress;
    }

    public String getLockStatus() {
        return lockStatus;
    }

    public List<Usage> getUsages() {
        return usages;
    }

    public List<Auth> getAuths() {
        return auths;
    }
}
