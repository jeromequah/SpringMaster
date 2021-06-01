package com.example.SpringMaster.Auth;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

// Auth - REST Layer
@RequestMapping(path = "api/v1/auths")
@RestController

// lombok
@AllArgsConstructor
public class AuthController {
    private final AuthService authService; // immutability

    // GET ALL Auth Details
    @GetMapping(path = "allAuth")
    public List<Auth> getAuths() {
        return authService.getAuths();
    }

    // GET SINGLE Auth Details
    @GetMapping(path = "getAuthDetails")
    public Auth getAuth(@Param("id") long id) {
        return authService.getAuth(id);
    }

    // CREATE Single Auth
    @PostMapping(path = "createAuth")
    public void createAuth(
            @Valid
            @RequestBody Auth auth
    ) {
        authService.createAuth(auth);
    }

    // DELETE Auth
    @DeleteMapping(path = "delete/{authId}")
    public void deleteAuth(@PathVariable("authId") long authId) {
        authService.deleteAuth(authId);
    }
}
