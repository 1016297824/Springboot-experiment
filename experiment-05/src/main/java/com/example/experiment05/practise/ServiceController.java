package com.example.experiment05.practise;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    @Autowired
    private Service service;
    @GetMapping("/exception")
    public void getException(){
        service.addFile();
    }
    @PostMapping("/user")
    public Map getbean(@Valid @RequestBody User user){
        return Map.of();
    }
}
