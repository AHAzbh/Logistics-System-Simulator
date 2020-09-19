package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class LogPointServiceImpl implements  LogPointService {
    @Autowired
    private LogPointDao logPointDao;
    public String findAll(){

        return  logPointDao.findAll().toString();
    }
    public String findById(String id){

        return logPointDao.findById(id).toString();
    }
    public String save(LogPoint logPoint){
        return logPointDao.save(logPoint).toString();
    }
    public void deleteById(String id){
        logPointDao.deleteById(id);
    }
}
