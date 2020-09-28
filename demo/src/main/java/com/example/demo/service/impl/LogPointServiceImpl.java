package com.example.demo.service.impl;

import com.example.demo.pojo.LogPoint;
import com.example.demo.service.LogPointService;
import com.example.demo.dao.LogPointDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("logPointService")
public class LogPointServiceImpl implements LogPointService {
    @Autowired
    private LogPointDao logPointDao;
    public List<LogPoint> findAll(){ return  logPointDao.findAll(); }
    public Optional<LogPoint> findById(String id){ return logPointDao.findById(id); }
    public LogPoint save(LogPoint logPoint){
        return logPointDao.save(logPoint);
    }
    public void deleteById(String id){
        logPointDao.deleteById(id);
    }
}
