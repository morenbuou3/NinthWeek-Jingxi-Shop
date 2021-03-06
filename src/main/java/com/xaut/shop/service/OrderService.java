package com.xaut.shop.service;

import com.xaut.shop.domain.entity.Order;
import com.xaut.shop.domain.entity.OrderProduct;

import java.util.List;

public interface OrderService {
    Order createOrder(List<OrderProduct> orderProducts, int userId);

    Order getOrderById(int id);

    void lockProductCount(List<OrderProduct> orderProducts) throws Exception;

    Order paidOrder(int id, String orderStatus);

    Order withdrawnOrder(int id, String orderStatus);

    void unlockProductCount(int id);

    void finishOrder(int orderId);

    List<Order> getOrders(int orderId);
}
