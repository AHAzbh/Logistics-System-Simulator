package com.example.demo;


import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Order {
    private String name;
    @Id
    private String id; //primary key
    private String origin;
    private String buyerId;
    private String sellerId;
    private String destination;
    private String nextPoint;
    private String status;

    public void setId(String id) {
        this.id = id;
    }

    @javax.persistence.Id
    public String getId() {
        return id;
    }

    /*set 和 get方法*/

}
