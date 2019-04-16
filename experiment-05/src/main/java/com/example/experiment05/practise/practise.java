package com.example.experiment05.practise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/practise")
public class practise {
    @GetMapping("/login")
    public Map getIndex() {
        return Map.of("name", "ZK");
    }

    @GetMapping("/addresses")
    public List getAddresses() {
        Address address1 = new Address(1, "753");
        Address address2 = new Address(2, "748");
        Address address3 = new Address(3, "754");
        return List.of(address1, address2, address3);
    }
}
