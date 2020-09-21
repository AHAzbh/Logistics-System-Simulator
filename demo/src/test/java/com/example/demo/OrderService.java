package com.example.demo;

public interface OrderService {
    public String findAll();
    public String findById(String id);
    public String save(Order order);
    public void deleteById(String id);
}
