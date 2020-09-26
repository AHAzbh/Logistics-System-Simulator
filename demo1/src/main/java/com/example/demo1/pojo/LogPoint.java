package com.example.demo1.pojo;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.List;

@Entity
public class LogPoint {
    @Id
    private String id; //primary key
    private List<String> orderList;
    private HashMap<String,String> orderMapping;
    private HashMap<String,List<String>>  courierMapping;
    private List<String> adjacentPoint;

    public void setId(String id) {
        this.id = id;
    }

    @javax.persistence.Id
    public String getId() {
        return id;
    }

    /*set、get*/


}
