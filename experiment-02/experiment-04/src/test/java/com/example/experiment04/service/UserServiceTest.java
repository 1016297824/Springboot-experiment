package com.example.experiment04.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void BuyCarTest() {
        userService.BuyCar();
    }

    @Test
    public void AddUserTest() {
        userService.AddUser();
    }
}