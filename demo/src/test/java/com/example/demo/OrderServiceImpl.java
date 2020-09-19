package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    public String findAll(){

        return  orderDao.findAll().toString();
    }
    public String findById(String id){

        return orderDao.findById(id).toString();
    }
    public String save(Order order){
        return orderDao.save(order).toString();
    }
    public void deleteById(String id){
        orderDao.deleteById(id);
    }


}
