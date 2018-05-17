package com.xaut.shop.service.serviceImpl;

import com.xaut.shop.domain.entity.Product;
import com.xaut.shop.domain.repo.ProductRepo;
import com.xaut.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public int createProduct(Product product) {
        return productRepo.save(product).getId();
    }
}
