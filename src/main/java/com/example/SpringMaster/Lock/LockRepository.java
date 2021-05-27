package com.example.SpringMaster.Lock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Lock - DATA ACCESS Layer
@Repository
public interface LockRepository
        extends JpaRepository<Lock, Long> {
    public Lock findByLockMacAddress(String lockMacAddress);
}
