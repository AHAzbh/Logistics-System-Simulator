package com.example.demo.service;

import com.example.demo.pojo.AyUser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface UserService {
	
    public List<AyUser> findAll();
    
    public Optional<AyUser> findById(String id);
    
    public AyUser save(AyUser ayUser);
    
    public void deleteById(String id);
            
    public void deleteAddr(String id, String address);
    
    public void addAddr(String id, String address);
}






