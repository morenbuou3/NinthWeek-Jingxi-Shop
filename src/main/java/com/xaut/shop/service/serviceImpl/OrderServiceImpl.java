package com.xaut.shop.service.serviceImpl;

import com.xaut.shop.domain.entity.Order;
import com.xaut.shop.domain.entity.OrderProduct;
import com.xaut.shop.domain.entity.Product;
import com.xaut.shop.domain.repo.OrderProductRepo;
import com.xaut.shop.domain.repo.OrderRepo;
import com.xaut.shop.domain.repo.ProductRepo;
import com.xaut.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderProductRepo orderProductRepo;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Order createOrder(List<OrderProduct> orderProducts) {
        Order order = new Order();
        order.setStatus("unPaid");
        try {
            order.setCreateTime(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double totalPrice = orderProducts.stream().mapToDouble(n -> {
            Product item = productRepo.getOne(n.getProductId());
            return item.getPrice() * n.getPurchaseCount();
        }).sum();
        order.setTotalPrice(totalPrice);
        orderRepo.save(order);
        for (OrderProduct n : orderProducts) {
            Product item = productRepo.getOne(n.getProductId());
            n.setProductName(item.getName());
            n.setProductDescription(item.getDescription());
            n.setPurchasePrice(item.getPrice());
            n.setOrder(order);
            orderProductRepo.save(n);
        }
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepo.getOne(id);
    }

    @Override
    @Transactional
    public void lockProductCount(List<OrderProduct> orderProducts) throws Exception {
        for (OrderProduct n : orderProducts) {
            Product item = productRepo.getOne(n.getProductId());
            if (item.getInventory().getCount() < n.getPurchaseCount()) {
                throw new RuntimeException(item.getName() + ":库存数量不够");
            } else {
                int count = item.getInventory().getCount();
                int lockCount = item.getInventory().getLockedCount();
                item.getInventory().setCount(count - n.getPurchaseCount());
                item.getInventory().setLockedCount(lockCount + n.getPurchaseCount());
                productRepo.save(item);
            }
        }
    }
}
