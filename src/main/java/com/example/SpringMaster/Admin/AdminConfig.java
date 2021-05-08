package com.example.SpringMaster.Admin;

import com.example.SpringMaster.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AdminConfig {

    @Value("${app.useFakeAdminRepo:false}") // default will be false for this variable
    private Boolean useFakeAdminRepo;

    @Value("${info.company.name}")
    private String companyName;

    @Autowired
    private Environment environment;

    @Bean
        // Initialises Spring, any code in args will be executed
    CommandLineRunner commandLineRunner(InfoApp infoApp) { // used upon App start
        return args -> {
            System.out.println("Command line runner");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(infoApp);
        };
    }

//    // Config for adminRepo implementation instead of @Qualifier
//    @Bean
//    AdminRepo adminRepo() {
//        System.out.println("useFakeAdminRepo = " + useFakeAdminRepo);
//        return new AdminFakeRepository(); // return fake if variable is TRUE
//    }
}
