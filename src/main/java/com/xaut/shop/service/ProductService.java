package com.xaut.shop.service;

import com.xaut.shop.domain.entity.Product;

import java.util.List;

public interface ProductService {
    int createProduct(Product product);

    void updateProduct(Product product);

    Product getProduct(int id);

    List<Product> getProducts();
}
