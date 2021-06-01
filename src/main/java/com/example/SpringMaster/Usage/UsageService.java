package com.example.SpringMaster.Usage;

import com.example.SpringMaster.Auth.Auth;
import com.example.SpringMaster.exception.BadRequestException;
import com.example.SpringMaster.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;

// Usage - SERVICE Layer (Business Logic)
@Component

// lombok
@AllArgsConstructor
@Slf4j
public class UsageService {
    private final UsageRepository usageRepository;

    // GET all usages
    List<Usage> getUsages() {
        log.info("getUsages called");
        return usageRepository.findAll();
    }

    // GET 1 Usage by ID
    Usage getUsage(long usageId) {
        return usageRepository
                .findById(usageId)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException =
                                    new NotFoundException(
                                            "Usage with ID " + usageId + " not Found");
                            log.error("error in getting Usage {}", usageId, notFoundException);
                            return notFoundException;
                        });
    }

    // POST 1 Usage
    public void createUsage(Usage newUsage) {
        long newUsageId = newUsage.getId();
        if (usageRepository.findById(newUsageId).isPresent()) {
            throw new BadRequestException("Usage with ID: " + newUsageId + " already exists!");
        } else {
            usageRepository.save(newUsage);
        }
    }

    // DELETE Usage
    public void deleteUsage(long usageId) {
        if (usageRepository.findById(usageId).isEmpty()) {
            throw new NotFoundException("Usage with ID: " + usageId + "does not exist!");
        } else {
            usageRepository.deleteById(usageId);
        }
    }
}
