package com.example.practise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PractiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractiseApplication.class, args);
    }

}
