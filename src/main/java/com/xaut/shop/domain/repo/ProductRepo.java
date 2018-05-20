package com.xaut.shop.domain.repo;

import com.xaut.shop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);

    List<Product> findByNameContainingAndDescriptionContaining(String name, String description);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Product findById(int id);
}
