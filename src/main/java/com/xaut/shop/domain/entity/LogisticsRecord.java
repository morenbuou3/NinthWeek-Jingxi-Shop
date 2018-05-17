package com.xaut.shop.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LogisticsRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String deliveryMan;
    private Date outboundTime;
    private Date signedTime;
    private String logisticsStatus;

    @OneToOne
    @JoinColumn(name = "orderItemId")
    private OrderItem orderItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Date getOutboundTime() {
        return outboundTime;
    }

    public void setOutboundTime(Date outboundTime) {
        this.outboundTime = outboundTime;
    }

    public Date getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
    }

    public String getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(String logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
