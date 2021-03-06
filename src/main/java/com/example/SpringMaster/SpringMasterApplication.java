package com.example.SpringMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

// this must be present in main class, if not app will not start
@SpringBootApplication
@EnableFeignClients // enable to consume data from other available APIs
public class SpringMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMasterApplication.class, args);
	}
}
