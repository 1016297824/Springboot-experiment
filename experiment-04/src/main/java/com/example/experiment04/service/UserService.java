package com.example.experiment04.service;

import com.example.experiment04.aspect.MyInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@MyInterceptor
public class UserService {
    public void BuyCar(){
        log.debug("BuyCar()");
    }
    @MyInterceptor(MyInterceptor.AuthorityType.ADMIN)
    public void AddUser(){
        log.debug("AddCar()");
    }
}
