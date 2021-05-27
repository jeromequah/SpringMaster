package com.example.SpringMaster.Lock;

import com.example.SpringMaster.exception.BadRequestException;
import com.example.SpringMaster.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

// Lock - SERVICE Layer (Business Logic)
@Component // Bean to onject in multiple places with SAME intance

// lombok
@AllArgsConstructor
@Slf4j

public class LockService {
    // Ref to Lock - DATA ACCESS Layer via Interface
    private final LockRepository lockRepository;

    // GET all Locks
    List<Lock> getLocks() {
        log.info("getLocks called");
        return lockRepository.findAll();
    }

    // GET 1 lock by Mac Address
    Lock getLock(String lockMacAddress) {
       Lock lock = lockRepository.findByLockMacAddress(lockMacAddress);
        if (lock != null) {
            return lock;
        } else {
            return new Lock();
        }
    }

    // POST 1 lock
    public void createLock(Lock newLock) {
        String newLockName = newLock.getLockName();
        if (lockRepository.findByLockMacAddress(newLockName) != null) {
            throw new BadRequestException("Lock with MAC Address: " + newLockName + " already exists!");
        } else {
            lockRepository.save(newLock);
        }
    }

    // DELETE lock
    public void deleteLock(long lockId) {
        if(lockRepository.findById(lockId).isEmpty()) {
            throw new NotFoundException("Lock with ID: " + lockId + "does not exist!");
        } else {
            lockRepository.deleteById(lockId);
        }
    }
}