package com.example.SpringMaster.Lock;

import feign.Param;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Lock - REST Layer
@RequestMapping(path = "api/v1/locks")
@RestController

// lombok
@AllArgsConstructor

public class LockController {
    private final LockService lockService; // immutability

    // GET ALL Lock Details
    @GetMapping(path = "allLock")
    public List<Lock> getLocks() {
        return lockService.getLocks();
    }

    // GET SINGLE Lock Details
    @GetMapping(path = "getLockDetails")
    public Lock getLock(@Param("lockMacAddress") String lockMacAddress) {
        return lockService.getLock(lockMacAddress);
    }

    // CREATE Single Lock
    @PostMapping(path = "createLock")
    public void createLock(
            @Valid // Invokes NotBlank for Lock Class
            @RequestBody Lock lock) {
        lockService.createLock(lock);
    }

    // DELETE Lock
    @DeleteMapping(path = "delete/{lockId}")
    public void deleteLock(@PathVariable("lockId") long lockId) {
        lockService.deleteLock(lockId);
    }
}
