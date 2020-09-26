package com.example.demo1.service;

import com.example.demo1.pojo.Orders;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Orders> findAll();
    public Optional<Orders> findById(String id);
    public Orders save(Orders orders);
    public void deleteById(String id);
    public String buy(Orders orders, Model model, HttpSession session);
    public String searchOrder(Model model, HttpSession session);


}
