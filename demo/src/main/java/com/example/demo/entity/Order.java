package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 订单
 */
@Entity
public class Order {

    @Id
    private String id;              // 订单编号
    private Date date;              // 订单时间
    private String sellerId;        // 订单卖方Id
    private String userId;          // 订单买方Id
    private String fromAddress;     // 订单起始地址
    private String toAddress;       // 订单目的地
    private String goodsId;         // 商品的Id
    private String nodeId;          // 当前所在节点的Id
    private Integer status;         // 订单状态，0表示未派送完成，1表示派送完成

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", sellerId='" + sellerId + '\'' +
                ", userId='" + userId + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", nodeId='" + nodeId + '\'' +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
