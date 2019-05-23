package com.example.experiment07.controller;

import com.example.experiment07.componet.EncryptorComponent;
import com.example.experiment07.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    private Map<String, User> userMap = new HashMap<>();

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EncryptorComponent encryptorComponent;

    @PostMapping("/register")
    public Map Register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMap.put(user.getUserName(), user);
        return Map.of("user", user);
        //return Map.of("password",user.getPassword());
    }

    @PostMapping("/login")
    public void Login(@RequestBody User user, HttpServletResponse response) {
        Optional.ofNullable(userMap.get(user.getUserName()))
                .or(() -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户名不存在！");
                })
                .ifPresent(u -> {
                    if (!passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "密码错误！");
                    }
                    Map map = Map.of("name", u.getUserName());
                    String token = encryptorComponent.encrypt(map);
                    response.setHeader("Authorization", token);
                });
    }

    @GetMapping("/index")
    public Map getIndex(@RequestAttribute String name) {
        log.debug(name);
        return Map.of("真实用户名", name);
    }
}