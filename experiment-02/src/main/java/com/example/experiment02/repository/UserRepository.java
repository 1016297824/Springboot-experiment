package com.example.experiment02.repository;

import com.example.experiment02.entity.Address;
import com.example.experiment02.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    /**
     * 添加用户，并返回包括数据库时间戳的用户对象
     * @param user
     * @return
     */
    public User addUser(User user) {
        em.persist(user);
        em.refresh(user);
        return user;
    }

    /**
     * 添加地址，并指定地址对应的用户
     * @param address
     * @param uid
     * @return
     */
    public Address addAddress(Address address, int uid) {
        User user = em.find(User.class, uid);
        address.setUser(user);
        em.persist(address);
        em.refresh(address);
        return address;
    }

    /**
     * 更新指定ID用户的姓名
     * @param uid
     * @param newName
     * @return
     */
    public User updateUser(int uid, String newName) {
        User user = em.find(User.class, uid);
        user.setName(newName);
        em.flush();
        return user;
    }

    /**
     * 尝试使用merge()，以及find()2种方法分别实现
     * 更新指定地址为指定用户
     * @param aid
     * @param uid
     * @return
     */
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

    /**
     * 返回指定用户的全部地址，没有返回空集合，而非null
     * @param uid
     * @return
     */
    public List<Address> listAddresses(int uid) {
        return List.of();
    }

    public void removeAddress(int aid) {

    }

    /**
     * 删除用户，设置级联操作或手动删除相关地址
     * @param uid
     */
    public void remaveUser(int uid) {

    }
}
