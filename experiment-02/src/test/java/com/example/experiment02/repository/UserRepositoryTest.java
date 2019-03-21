package com.example.experiment02.repository;

import com.example.experiment02.entity.Address;
import com.example.experiment02.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void addAddress(){
        Address address = userRepository.addAddress(new Address("753"), 1);
        log.debug("{}",address.getInsertTime());

        Address address1 = userRepository.addAddress(new Address("748"), 2);
        log.debug("{}",address1.getInsertTime());
    }

    @Test
    public void updateUser() {
        User user = userRepository.updateUser(2, "FLJ");
        log.debug(user.getName());
    }

    @Test
    public void updateAddress_Find(){
        userRepository.updateAddress_Find(1, 2);
    }

    @Test
    public void updateAddress_Merge() {
        userRepository.updateAddress_Merge(1, 1);
    }
}