package com.example.demo.pojo;

import org.springframework.data.annotation.Id;

import lombok.Data;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.List;

@Data
@Entity
public class LogPoint {
    @Id
    private String id; //primary key
    
    private List<String> orderList;
    
    private HashMap<String,String> orderMapping;
    
    private HashMap<String,List<String>>  courierMapping;
    
    private List<String> adjacentPoint;

}
