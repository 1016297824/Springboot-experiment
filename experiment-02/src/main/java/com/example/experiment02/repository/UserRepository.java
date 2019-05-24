package com.example.experiment02.repository;

import com.example.experiment02.entity.Address;
import com.example.experiment02.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public User addUser(User user) {
        em.persist(user);
        em.refresh(user);
        return user;
    }

    public Address addAddress(Address address, int uid) {
        User user = em.find(User.class, uid);
        address.setUser(user);
        em.persist(address);
        em.refresh(address);
        return address;
    }

    public User updateUser(int uid, String newName) {
        User user = em.find(User.class, uid);
        user.setName(newName);
        em.flush();
        return user;
    }

    public Address updateAddress_Find(int aid, int uid) {

        User user = em.find(User.class, uid);

        Address address = em.find(Address.class, aid);
        address.setUser(user);
        em.flush();
        return address;
    }

    public Address updateAddress_Merge(int aid,int uid){
        User user = new User();
        user.setId(uid);
        User user1 = em.merge(user);
        em.refresh(user1);

        Address address = new Address();
        address.setId(aid);
        Address address1 = em.merge(address);
        em.refresh(address1);

        address1.setUser(user1);

        return address1;
    }

    public List<Address> listAddresses(int uid) {
        User user = em.find(User.class, uid);
        ArrayList<Address> addressList = new ArrayList<>(user.getAddresses());
        //List.of(addressList);
        return addressList;
    }

    public void removeAddress(int aid) {
        Address address = em.find(Address.class, 3);
        em.remove(address);
    }

    public void removeUser(int uid) {
        User user = em.find(User.class, 2);
        em.remove(user);
    }
}
