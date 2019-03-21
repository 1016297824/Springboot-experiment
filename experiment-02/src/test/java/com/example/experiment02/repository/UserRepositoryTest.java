package com.example.experiment02.repository;

import com.example.experiment02.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser() {
        User user = new User("ZK");
        User user1 = userRepository.addUser(user);
        User user2 = userRepository.addUser(new User("FLJ"));
        log.debug("{}",user1.getInsertTime());
        log.debug("{}",user2.getInsertTime());
    }
}