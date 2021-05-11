package com.example.SpringMaster.Admin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.annotation.WebInitParam;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Unit Testing for AdminService
// TODO Debug Jpa Test
@DataJpaTest // Bringing in the real dependency
class AdminServiceTest {

    @Autowired
    private AdminRepository adminRepository;
    private AdminService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AdminService(adminRepository);
    }

    @AfterEach
    void tearDown() {
        adminRepository.deleteAll(); // deletes all in DB
    }

    @Test
    void getAdmins() {
        // given data - test Admins
        Admin a1 = new Admin(
                1,
                "A1 Test",
                "a1test@gmail.com",
                LocalDate.of(1997, Month.MARCH,28),
                "92939292",
                "P@ssword123!"
        );
        Admin a2 = new Admin(
                2,
                "A2 Test",
                "a2test@gmail.com",
                LocalDate.of(2000, Month.JANUARY,22),
                "90008800",
                "P@ssword12345!"
        );

        adminRepository.saveAll(Arrays.asList(a1,a2)); // save test Admins into Repo

        // when
        List<Admin> admins = underTest.getAdmins(); // Actual Test

        // then
        assertEquals(2, admins.size()); // (Expected number of admins, Actual)
    }

    @Test
    void getAdmin() {

        Admin a1 = new Admin(
                1,
                "A1 Test",
                "a1test@gmail.com",
                LocalDate.of(1997, Month.MARCH,28),
                "92939292",
                "P@ssword123!"
        );

        adminRepository.save(a1); // save test Admin into Repo

        Admin actual = underTest.getAdmin("a1test@gmail.com");

//        Expected vs Actual
        assertEquals(1, actual.getId());
        assertEquals("A1 Test", actual.getFullName());
        assertEquals(LocalDate.of(1997, Month.MARCH,28), actual.getDob());
        assertEquals("92939292", actual.getMobileNumber());
        assertEquals("P@ssword123!", actual.getPassword());

    }

//    @Test
//    void createAdmin() {
//    }
}