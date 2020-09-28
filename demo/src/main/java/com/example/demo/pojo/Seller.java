package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="seller")
public class Seller {
	
	private String id;
	
	private String name;
	
}
