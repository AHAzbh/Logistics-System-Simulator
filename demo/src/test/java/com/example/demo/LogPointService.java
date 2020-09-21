package com.example.demo;

public interface LogPointService {
    public String findAll();
    public String findById(String id);
    public String save(LogPoint logPoint);
    public void deleteById(String id);
}
