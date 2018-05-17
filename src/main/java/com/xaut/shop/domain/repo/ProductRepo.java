package com.xaut.shop.domain.repo;

import com.xaut.shop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
