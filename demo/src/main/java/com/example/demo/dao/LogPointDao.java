package com.example.demo.dao;

import com.example.demo.pojo.LogPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogPointDao extends JpaRepository<LogPoint,String> {
}
