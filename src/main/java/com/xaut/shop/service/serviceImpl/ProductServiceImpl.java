package com.xaut.shop.service.serviceImpl;

import com.xaut.shop.domain.entity.Product;
import com.xaut.shop.domain.repo.ProductRepo;
import com.xaut.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public int createProduct(Product product) {
        return productRepo.save(product).getId();
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public Product getProduct(int id) {
        return productRepo.getOne(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
