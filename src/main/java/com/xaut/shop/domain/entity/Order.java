package com.xaut.shop.domain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float totalPrice;
    private String status;
    private Date createTime;
    private Date finishTime;
    private Date paidTime;
    private Date withdrawnTime;

    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProducts;
    @OneToOne(mappedBy = "order")
    private LogisticsRecord logisticsRecord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Date getWithdrawnTime() {
        return withdrawnTime;
    }

    public void setWithdrawnTime(Date withdrawnTime) {
        this.withdrawnTime = withdrawnTime;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
