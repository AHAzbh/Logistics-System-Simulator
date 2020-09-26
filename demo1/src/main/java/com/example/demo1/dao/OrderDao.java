package com.example.demo1.dao;

import com.example.demo1.pojo.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Orders,String> {

    @Query(value="select a from Orders a where a.buyerId=?1")
    List<Orders> searchOrder(String s);
}
