package com.example.demo.dao;

import com.example.demo.pojo.AyUser;
import com.example.demo.pojo.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<AyUser,String> {
	
    @Modifying
    @Query(value="delete from Buyer a where a.id=?1 and a.address =?2")
    void deleteAddr(String id, String address);

    @Modifying
    @Query(value="insert into buyer(id,address) values(?1,?2)",nativeQuery = true)
    void addAddr(String id,String address);

}
