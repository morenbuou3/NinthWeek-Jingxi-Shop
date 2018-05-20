package com.xaut.shop.web;

import com.xaut.shop.domain.entity.Order;
import com.xaut.shop.domain.entity.OrderProduct;
import com.xaut.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody List<OrderProduct> orderProducts) throws Exception {
        orderService.lockProductCount(orderProducts);
        return orderService.createOrder(orderProducts);
    }

    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PutMapping(value = "/{id}", params = "orderStatus")
    public Order paidOrder(@PathVariable int id, @RequestParam String orderStatus) {
        return orderService.paidOrder(id, orderStatus);
    }
}
