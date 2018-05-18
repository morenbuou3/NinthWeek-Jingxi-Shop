package com.xaut.shop.service;

import com.xaut.shop.domain.entity.Product;

public interface ProductService {
    int createProduct(Product product);

    void updateProduct(Product product);
}
