package com.xaut.shop.domain.repo;

import com.xaut.shop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);

    List<Product> findByNameContainingAndDescriptionContaining(String name, String description);
}
