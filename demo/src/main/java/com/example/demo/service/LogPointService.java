package com.example.demo.service;

import com.example.demo.pojo.LogPoint;
import java.util.List;
import java.util.Optional;

public interface LogPointService {
    
	public List<LogPoint> findAll();
    
	public Optional<LogPoint> findById(String id);
    
	public LogPoint save(LogPoint logPoint);
    
	public void deleteById(String id);
}
