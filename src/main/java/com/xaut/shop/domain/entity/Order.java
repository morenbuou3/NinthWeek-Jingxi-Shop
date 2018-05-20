package com.xaut.shop.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double totalPrice;
    private String status;
    private Date createTime;
    private Date finishTime;
    private Date paidTime;
    private Date withdrawnTime;

    @OneToMany(mappedBy = "order")
    @OrderBy(value = "id ASC")
    private Set<OrderProduct> purchaseItemList;
    @OneToOne(mappedBy = "order")
    private LogisticsRecord logisticsRecord;

    @ManyToOne
    @JsonIgnore
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
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

    public Set<OrderProduct> getPurchaseItemList() {
        return purchaseItemList;
    }

    public void setPurchaseItemList(Set<OrderProduct> purchaseItemList) {
        this.purchaseItemList = purchaseItemList;
    }

    public LogisticsRecord getLogisticsRecord() {
        return logisticsRecord;
    }

    public void setLogisticsRecord(LogisticsRecord logisticsRecord) {
        this.logisticsRecord = logisticsRecord;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
