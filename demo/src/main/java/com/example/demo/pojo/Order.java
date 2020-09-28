package com.example.demo.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order")
public class Order {
    
	@Id
    private String id; //primary key
    
	private String start;
	
	private String destination;
    
	private String buyerId;
    
	private String sellerId;
	
	private String goodsId;
	
	private String nodeId;
    
	private String nextPoint;
	
	private Integer status;
    
	private String log;
}
