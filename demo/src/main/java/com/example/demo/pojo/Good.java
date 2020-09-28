package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="good")
public class Good {
    
	@Id
    private String id;
    
	private String name;
    
	private String seller_id;
    
	private String seller_address;
}
