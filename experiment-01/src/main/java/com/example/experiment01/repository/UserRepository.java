package com.example.experiment01.repository;

import com.example.experiment01.entity.Address;
import com.example.experiment01.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public void addUserAddress() {
        User user1 = new User("ZK");
        em.persist(user1);

        Address address1 = new Address("753",null);
        address1.setUser(user1);
        em.persist(address1);

        Address address2 = new Address("754",null);
        address2.setUser(user1);
        em.persist(address2);

        User user2 = new User("FLJ");
        em.persist(user2);

        Address address3 = new Address("748",user2);
        em.persist(address3);
    }
}