package com.example.experiment05.practise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/practise")
public class practise {
    @GetMapping("/login")
    public Map getIndex() {
        return Map.of("name", "ZK");
    }

    @GetMapping("/addresses1")
    public List getAddresses1() {
        Address address1 = new Address(1, "753");
        Address address2 = new Address(2, "748");
        Address address3 = new Address(3, "754");
        return List.of(address1, address2, address3);
    }

    @GetMapping("/addresses2")
    public Map getAddresses2() {
        Address address1 = new Address(1, "753");
        Address address2 = new Address(2, "748");
        Address address3 = new Address(3, "754");
        return Map.of("address2", List.of(address1,address2,address3));
    }

    @PostMapping("/addresses3")
    public Map postLogin1(@RequestBody Address address){
        log.debug("{}",address.getDetail());
        address.setInsertTime(LocalDateTime.now());
        return Map.of("address",address);
    }

    @PostMapping("/addresses4")
    public Map postLogin2(Address address){
        log.debug("{}",address.getDetail());
        return Map.of("address",address);
    }

    @GetMapping("/news1/{nid}")
    public Map getNews1(@PathVariable int nid){
        log.debug("{}",nid);
        return Map.of("nid",nid);
    }

    @GetMapping("/news2/{nid}")
    public Map getNews2(@PathVariable("nid") int newId){
        log.debug("{}",newId);
        return Map.of("newId",newId);
    }
}
