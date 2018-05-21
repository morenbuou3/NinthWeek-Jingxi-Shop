package com.xaut.shop.web;

import com.xaut.shop.domain.entity.Order;
import com.xaut.shop.domain.entity.OrderProduct;
import com.xaut.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody List<OrderProduct> orderProducts,
                            HttpSession session, HttpServletResponse response) throws Exception {
        orderService.lockProductCount(orderProducts);
        /*int userId = (int) session.getAttribute("userId");*/
        int userId = 1;
        int orderId = orderService.createOrder(orderProducts, userId).getId();
        response.setHeader("location", "/orders/" + orderId);
    }

    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void paidOrder(@PathVariable int id, @RequestParam String orderStatus,
                          HttpServletResponse response) {
        if ("paid".equals(orderStatus)) {
            orderService.paidOrder(id, orderStatus);
        }
        if ("withdrawn".equals(orderStatus)) {
            orderService.unlockProductCount(id);
            orderService.withdrawnOrder(id, orderStatus);
        }
        response.setHeader("location", "/orders/" + id);
    }

    @GetMapping
    public List<Order> getOrders(@RequestParam int userId) {
        return orderService.getOrders(userId);
    }
}
