package com.example.experiment02.repository;

import com.example.experiment02.entity.Address;
import com.example.experiment02.entity.User;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.build.Plugin;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Priority;
import java.util.List;
import java.util.PriorityQueue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest() {
        User user = new User("ZK");
        User user1 = userRepository.addUser(user);
        log.debug("{}",user1.getInsertTime());

        User user2 = userRepository.addUser(new User("FLJ"));
        log.debug("{}",user2.getInsertTime());

        User user3 = userRepository.addUser(new User("GPX"));
        log.debug("{}",user3.getInsertTime());
    }

    @Test
    public void addAddressTest(){
        Address address1 = userRepository.addAddress(new Address("753"), 1);
        log.debug("{}",address1.getInsertTime());

        Address address2 = userRepository.addAddress(new Address("748"), 2);
        log.debug("{}",address2.getInsertTime());

        Address address3 = userRepository.addAddress(new Address("748"), 1);
        log.debug("{}",address3.getInsertTime());
    }

    @Test
    public void updateUserTest() {
        User user = userRepository.updateUser(2, "FLJ-01");
        log.debug(user.getName());
    }

    @Test
    public void updateAddress_FindTest(){
        Address address = userRepository.updateAddress_Find(1, 2);
        log.debug("{}",address.getUser().getId());
    }

    @Test
    public void updateAddress_MergeTest() {
        Address address = userRepository.updateAddress_Merge(1, 1);
        log.debug("{}",address.getUser().getId());
    }


    @Test
    public void listAddressesTest() {
        List<Address> addressList = userRepository.listAddresses(3);
        for (Address address :
                addressList) {
            log.debug("{}",address.getDetail());
        }
    }

    @Test
    public void removeAddressTest() {
        userRepository.removeAddress(3);
    }

    @Test
    public void removeUserTest() {
        userRepository.removeUser(2);
    }
}