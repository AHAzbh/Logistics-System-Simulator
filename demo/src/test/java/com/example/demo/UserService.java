package com.example.demo;


public interface UserService {
    public String findAll();
    public String findById(String id);
    public String save(AyUser ayUser);
    public void deleteById(String id);
}
