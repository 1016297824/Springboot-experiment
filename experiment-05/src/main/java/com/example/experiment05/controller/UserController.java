package com.example.experiment05.controller;

import com.example.experiment05.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    private static List<User> users=create();
    private static List<User> create(){
        users=new ArrayList<>();
        User user=new User(1, "Zk", "123456", "753");
        User user1=new User(2, "FLJ", "987654", "748");
        User user2=new User(3, "JZX", "654321", "754");
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }

    @GetMapping("/Index")
    public Map getIndex(){
        return Map.of("index","main");
    }

    @GetMapping("/Users")
    public Map getUsers(){
        return Map.of("users", users);
    }

    @GetMapping("/Users/{uid}")
    public Map getUser(@PathVariable int uid){
        log.debug("{}",uid);
        User user=users.stream()
                .filter(u -> u.getId()==uid)
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(user)
                .map(u->Map.of("user",u))
                .orElse(Map.of());
    }
}
