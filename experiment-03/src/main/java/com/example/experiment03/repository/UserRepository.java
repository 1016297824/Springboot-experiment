package com.example.experiment03.repository;

import com.example.experiment03.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.id=:id")
    User find(@Param("id") int id);
}
