package com.example.demo1.dao;

import com.example.demo1.pojo.LogPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogPointDao extends JpaRepository<LogPoint,String> {
}
