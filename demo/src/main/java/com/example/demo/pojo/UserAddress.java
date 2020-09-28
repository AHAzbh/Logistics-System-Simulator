package com.example.demo.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="userAddress")
public class UserAddress implements Serializable {
    private static final long serialVersionUID = 15;
    
    private String id;
    
    private String address;
}
