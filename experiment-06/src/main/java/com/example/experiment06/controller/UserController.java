package com.example.experiment06.controller;

import com.example.experiment06.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.security.PublicKey;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@Validated
public class UserController {
    @PostMapping("/User")
    public Map postUser(@Valid @RequestBody User user){
        return Map.of("user",user);
    }

    @GetMapping("/User/{userName}")
    public void getViolationException(
            @Size(min=3,max = 6,message = "用户参数信息错误！")
            @PathVariable String userName){
    }
}
