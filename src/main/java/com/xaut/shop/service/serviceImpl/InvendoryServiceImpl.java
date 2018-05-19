package com.xaut.shop.service.serviceImpl;

import com.xaut.shop.domain.entity.Inventory;
import com.xaut.shop.domain.repo.InventoryRepo;
import com.xaut.shop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvendoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public void updateInventory(Inventory inventory, int id) {
        Inventory entity = getInventoryByProductId(id);
        entity.setCount(inventory.getCount());
        inventoryRepo.save(entity);
    }

    @Override
    public Inventory getInventoryByProductId(int id) {
        return inventoryRepo.findByProduct_id(id);
    }
}
