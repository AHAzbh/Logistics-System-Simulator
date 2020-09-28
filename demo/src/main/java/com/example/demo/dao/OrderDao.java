package com.example.demo.dao;

import com.example.demo.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order,String> {

    @Query(value="select a from Orders a where a.buyerId=?1")
    List<Order> searchOrder(String s);
}
