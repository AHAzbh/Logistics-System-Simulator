package com.example.demo.service;

import com.example.demo.pojo.Order;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    
	public List<Order> findAll();
    
	public Optional<Order> findById(String id);
    
	public Order save(Order orders);
    
	public void deleteById(String id);
    
	public String buy(Order orders, Model model, HttpSession session);
    
	public String searchOrder(Model model, HttpSession session);

}
