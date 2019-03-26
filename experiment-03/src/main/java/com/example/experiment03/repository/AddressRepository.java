package com.example.experiment03.repository;

import com.example.experiment03.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("select a from Address a where a.detail=:detail")
    List<Address> list(@Param("detail") String detail);
}
