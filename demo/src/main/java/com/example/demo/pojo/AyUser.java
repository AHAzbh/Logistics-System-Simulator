package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ayuser")
public class AyUser {
    @Id
    private String id; //primary key
    
    private String name;
    
    private int age;
    
    private String cell;
    
    private String password;
}
