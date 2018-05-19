package com.xaut.shop.service.serviceImpl;

import com.xaut.shop.domain.entity.Inventory;
import com.xaut.shop.domain.entity.Product;
import com.xaut.shop.domain.repo.InventoryRepo;
import com.xaut.shop.domain.repo.ProductRepo;
import com.xaut.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public int createProduct(Product product) {
        int id = productRepo.save(product).getId();
        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventoryRepo.save(inventory);
        return id;
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

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Product> getProductsLikeNameAndDescription(String name, String description) {
        return productRepo.findByNameContainingAndDescriptionContaining(name, description);
    }
}
