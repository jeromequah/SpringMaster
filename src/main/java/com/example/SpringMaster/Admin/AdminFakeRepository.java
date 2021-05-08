package com.example.SpringMaster.Admin;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

//@Repository(value = "fake") This class will be available as a Bean, parse value as fake repo
public class AdminFakeRepository implements AdminRepo{
    @Override
    public List<Admin> getAdmins() {
        return Arrays.asList(
                new Admin(
                        1,
                        "Jerome Quah Wei Ren",
                        "jeromequah123@msn.com",
                        LocalDate.of(1997, Month.MARCH,28),
                        "98765432",
                        "password"),
                new Admin(
                        2,
                        "Jane Quah Li Ren",
                        "janequah123@msn.com",
                        LocalDate.of(1997, Month.MARCH,28),
                        "98765431",
                        "password")
        );
    }
}
