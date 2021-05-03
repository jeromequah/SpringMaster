package com.example.SpringMaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

// this must be present in main class, if not app will not start
@SpringBootApplication
@RestController
public class SpringMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMasterApplication.class, args);
	}

	@GetMapping
	Admin getAdmin() {
		return new Admin(
				1,
				"Jerome Quah Wei Ren",
				"jeromequah123@msn.com",
				LocalDate.of(1997, Month.MARCH,28),
				"98765432",
				"password");
	}

	// Admin - Class
	class Admin {
		private final long id;
		private final String fullName;
		private final String email;
		private final LocalDate dob;
		private final String mobileNumber;
		private final String password;

		// Admin - Constructor
		Admin(long id, String fullName, String email, LocalDate dob, String mobileNumber, String password) {
			this.id = id;
			this.fullName = fullName;
			this.email = email;
			this.dob = dob;
			this.mobileNumber = mobileNumber;
			this.password = password;
		}
		// Admin - Getter
		public long getId() {
			return id;
		}

		public String getFullName() {
			return fullName;
		}

		public String getEmail() {
			return email;
		}

		public LocalDate getDob() {
			return dob;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public String getPassword() {
			return password;
		}
	}

}
