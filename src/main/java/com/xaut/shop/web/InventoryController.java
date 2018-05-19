package com.xaut.shop.web;

import com.xaut.shop.domain.entity.Inventory;
import com.xaut.shop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PutMapping(value = "/{id}")
    public String updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
        inventoryService.updateInventory(inventory, id);
        return "redirect:/products/" + id;
    }

}
