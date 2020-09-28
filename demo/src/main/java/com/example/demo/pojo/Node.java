package com.example.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="node")
public class Node {
	
	private String id;
	
	private String address;
}
