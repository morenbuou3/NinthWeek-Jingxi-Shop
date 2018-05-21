package com.xaut.shop.web;

import com.xaut.shop.domain.entity.Inventory;
import com.xaut.shop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInventory(@PathVariable int id, @RequestBody Inventory inventory,
                                HttpServletResponse response) {
        inventoryService.updateInventory(inventory, id);
        response.setHeader("location", "/inventories/" + id);
    }

}
