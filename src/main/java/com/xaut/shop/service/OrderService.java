package com.xaut.shop.service;

import com.xaut.shop.domain.entity.Order;
import com.xaut.shop.domain.entity.OrderProduct;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderService {
    Order createOrder(List<OrderProduct> orderProducts);

    Order getOrderById(int id);

    void lockProductCount(List<OrderProduct> orderProducts) throws Exception;

    Order paidOrder(int id, String orderStatus);
}
