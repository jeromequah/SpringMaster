package com.example.SpringMaster.Admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    @Value("${app.useFakeAdminRepo:false}") // default will be false for this variable
    private Boolean useFakeAdminRepo;

    @Bean
        // Initialises Spring, any code in args will be executed
    CommandLineRunner commandLineRunner() { // used upon App start
        return args -> {
            System.out.println("Command line runner yay");
        };
    }

    // Config for adminRepo implementation instead of @Qualifier
    @Bean
    AdminRepo adminRepo() {
        System.out.println("useFakeAdminRepo = " + useFakeAdminRepo);
        return useFakeAdminRepo ?
                new AdminFakeRepository() : // return fake if variable is TRUE
                new AdminRepository(); // else return the repo

    }
}
