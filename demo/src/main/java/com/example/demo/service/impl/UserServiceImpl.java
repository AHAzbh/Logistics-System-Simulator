package com.example.demo.service.impl;

import com.example.demo.pojo.AyUser;
import com.example.demo.service.UserService;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Repository("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    public List<AyUser> findAll(){ 
    	return  userDao.findAll(); 
    }
    
    public Optional<AyUser> findById(String id){ 
    	return userDao.findById(id); 
    }
    
    public AyUser save(AyUser ayUser){
        return userDao.save(ayUser);
    }
    
    public void deleteById(String id){
        userDao.deleteById(id);
    }
    

    @Transactional
    public void deleteAddr(String id, String address){
        userDao.deleteAddr(id, address);
    }
    
    @Transactional
    public void addAddr(String id, String address){
        userDao.addAddr(id ,address);
    }

}
