package com.xaut.shop.domain.repo;

import com.xaut.shop.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
}
