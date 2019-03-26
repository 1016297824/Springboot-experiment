package com.example.experiment03;

import com.example.experiment03.entity.Address;
import com.example.experiment03.entity.User;
import com.example.experiment03.entity.UserAddress;
import com.example.experiment03.repository.AddressRepository;
import com.example.experiment03.repository.UserAddressRepository;
import com.example.experiment03.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JPQLTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Test
    public void init(){
        User user1 = new User("ZK");
        userRepository.save(user1);
        User user2 = new User("FLJ");
        userRepository.save(user2);

        Address address1 = new Address("753");
        addressRepository.save(address1);
        Address address2 = new Address("748");
        addressRepository.save(address2);
        Address address3 = new Address("754");
        addressRepository.save(address3);

        UserAddress userAddress1 = new UserAddress(user1, address1);
        userAddressRepository.save(userAddress1);
        UserAddress userAddress2 = new UserAddress(user2,address2);
        userAddressRepository.save(userAddress2);
        UserAddress userAddress3 = new UserAddress(user1, address3);
        userAddressRepository.save(userAddress3);
    }

    @Test
    public void userRepositoryTest(){
        User user = userRepository.find(1);
        log.debug(user.getName());
    }

    @Test
    public void addressRepositoryTest(){
        //List<Address> addressList = addressRepository.list("753");
        //for (Address address : addressList){
        //    log.debug("{}",address.getId());
        //}

        addressRepository.list("753")
                .forEach(address -> {
                    log.debug("{}",address.getId());
                        }
                );
    }

    @Test
    public void userAddressRepositoryTest(){
        UserAddress userAddress = userAddressRepository.find("ZK", "753");
        log.debug("插入时间：{}",userAddress.getInsertTime());
    }
}