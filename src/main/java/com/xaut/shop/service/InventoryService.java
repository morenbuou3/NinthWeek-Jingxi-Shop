package com.xaut.shop.service;

import com.xaut.shop.domain.entity.Inventory;

public interface InventoryService {
    void updateInventory(Inventory inventory, int id);

    Inventory getInventoryByProductId(int id);
}
