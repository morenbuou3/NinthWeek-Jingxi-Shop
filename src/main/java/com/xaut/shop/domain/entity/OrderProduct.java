package com.xaut.shop.domain.entity;

import javax.persistence.*;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private String productDescription;
    private float purchasePrice;
    private int purchaseCount;

    @ManyToOne
    @JoinColumn(name = "orderItemId")
    private OrderItem orderItem;
    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
