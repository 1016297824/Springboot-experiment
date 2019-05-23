package com.example.practise.TimerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyTimer {
    @Scheduled(cron = "*/5 * * * * *")
    public void myTimer(){
        log.debug("MyTimer!");
    }
}
