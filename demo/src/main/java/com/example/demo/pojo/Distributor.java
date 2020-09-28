package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="distributor")
public class Distributor {
	
	private String id;
	
	private String name;
}
