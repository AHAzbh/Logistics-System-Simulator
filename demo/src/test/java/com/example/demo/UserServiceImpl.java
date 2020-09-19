package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public String findAll(){

        return  userDao.findAll().toString();
    }
    public String findById(String id){

        return userDao.findById(id).toString();
    }
    public String save(AyUser ayUser){
        return userDao.save(ayUser).toString();
    }
    public void deleteById(String id){
        userDao.deleteById(id);
    }

}
