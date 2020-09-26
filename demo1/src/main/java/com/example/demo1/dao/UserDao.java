package com.example.demo1.dao;

import com.example.demo1.pojo.AyUser;
import com.example.demo1.pojo.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<AyUser,String> {
    @Query(value = "select a from AyUser a where a.id=?1 and a.password=?2")
    AyUser login(String id,String pwd);

    @Modifying
    @Query(value="delete from Buyer a where a.id=?2 and a.address =?1")
    void deleteAddr(String s,String id);

    @Modifying
    @Query(value="insert into buyer(id,address) values(?1,?2)",nativeQuery = true)
    void addAddr(String id,String address);

    @Query(value="select a from Buyer a where a.id=?1")
    List<Buyer> addresses(String s);
}
