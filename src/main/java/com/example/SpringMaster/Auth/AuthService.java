package com.example.SpringMaster.Auth;

import com.example.SpringMaster.exception.BadRequestException;
import com.example.SpringMaster.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// Auth - SERVICE Layer (Business Logic)

@Component // Bean to object in multiple places with SAME instance

// lombok
@AllArgsConstructor
@Slf4j

public class AuthService {
    // Ref to Auth - DATA ACCESS Layer via Interface
    private final AuthRepository authRepository;

    // GET all auths
    List<Auth> getAuths() {
        log.info("getAuths called");
        return authRepository.findAll();
    }

    // GET 1 Auth by ID
    Auth getAuth(long authId) {
        return authRepository
                .findById(authId)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException =
                                    new NotFoundException(
                                            "Auth with ID " + authId + " not Found");
                            log.error("error in getting Auth {}", authId, notFoundException);
                            return notFoundException;
                        });
    }

    // POST 1 auth
    public void createAuth(Auth newAuth) {
        long newAuthId = newAuth.getId();
        if (authRepository.findById(newAuthId).isPresent()) {
            throw new BadRequestException("Lock with ID: " + newAuthId + " already exists!");
        } else {
            authRepository.save(newAuth);
        }
    }

    // DELETE auth
    public void deleteAuth(long authId) {
        if(authRepository.findById(authId).isEmpty()){
            throw new NotFoundException("Auth with ID: " + authId + "does not exist!");
        } else {
            authRepository.deleteById(authId);
        }
    }
}
