package com.xaut.shop.web;

import com.xaut.shop.domain.entity.Order;
import com.xaut.shop.domain.entity.OrderProduct;
import com.xaut.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody List<OrderProduct> orderProducts, HttpSession session) throws Exception {
        orderService.lockProductCount(orderProducts);
        /*int userId = (int) session.getAttribute("userId");*/
        int userId = 1;
        return orderService.createOrder(orderProducts, userId);
    }

    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PutMapping(value = "/{id}", params = "orderStatus")
    public Order paidOrder(@PathVariable int id, @RequestParam String orderStatus) {
        if ("paid".equals(orderStatus)) {
            return orderService.paidOrder(id, orderStatus);
        } else {
            orderService.unlockProductCount(id);
            return orderService.withdrawnOrder(id, orderStatus);
        }
    }

    @GetMapping(params = "userId")
    public List<Order> getOrders(@RequestParam int userId) {
        return orderService.getOrders(userId);
    }
}
