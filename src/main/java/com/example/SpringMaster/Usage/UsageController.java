package com.example.SpringMaster.Usage;
import feign.Param;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// USAGE - REST Layer
@RequestMapping(path = "api/v1/usages")
@RestController

// lombok
@AllArgsConstructor
public class UsageController {
    private final UsageService usageService;

    // GET ALL Usage Details
    @GetMapping(path = "allUsage")
    public List<Usage> getUsages() {
        return usageService.getUsages();
    }

    // GET SINGLE Usage Details
    @GetMapping(path = "getUsageDetails")
    public Usage getUsage(@Param("id") long id) {
        return usageService.getUsage(id);
    }

    // CREATE Single Usage
    @PostMapping(path = "createUsage")
    public void createUsage(
            @Valid
            @RequestBody Usage usage) {
        usageService.createUsage(usage);
    }

    // DELETE Usage
    @DeleteMapping(path = "delete/{usageId}")
    public void deleteUsage(@PathVariable("usageId") long usageId) {
        usageService.deleteUsage(usageId);
    }
}
