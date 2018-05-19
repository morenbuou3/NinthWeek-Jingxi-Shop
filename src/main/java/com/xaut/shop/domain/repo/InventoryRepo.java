package com.xaut.shop.domain.repo;

import com.xaut.shop.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    Inventory findByProduct_id(int id);
}
