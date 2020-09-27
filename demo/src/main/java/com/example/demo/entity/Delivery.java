package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 配送员
 */
@Entity
public class Delivery {
    @Id
    private String id;          // 配送员的Id
    private String name;        // 配送员姓名
    private String node1;       // 配送员所负责节点1的Id
    private String node2;       // 配送员所负责节点2的Id

    @Override
    public String toString() {
        return "Delivery{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNode1() {
        return node1;
    }

    public void setNode1(String node1) {
        this.node1 = node1;
    }

    public String getNode2() {
        return node2;
    }

    public void setNode2(String node2) {
        this.node2 = node2;
    }
}
