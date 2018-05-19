package com.xaut.shop.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int count;
    private int lockedCount;

    @OneToOne
    @JsonIgnore
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLockedCount() {
        return lockedCount;
    }

    public void setLockedCount(int lockedCount) {
        this.lockedCount = lockedCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
