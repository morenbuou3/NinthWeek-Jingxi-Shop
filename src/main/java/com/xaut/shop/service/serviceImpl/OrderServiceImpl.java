package com.xaut.shop.service.serviceImpl;

import com.xaut.shop.domain.entity.*;
import com.xaut.shop.domain.repo.*;
import com.xaut.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderProductRepo orderProductRepo;
    @Autowired
    private LogisticsRecordRepo logisticsRecordRepo;
    @Autowired
    private UserRepo userRepo;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Order createOrder(List<OrderProduct> orderProducts, int userId) {
        Order order = new Order();
        User user = userRepo.getOne(userId);
        order.setUserId(userId);
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
            Product item = productRepo.findById(n.getProductId());
            if (item.getInventory().getCount() < n.getPurchaseCount()) {
                throw new RuntimeException(item.getName() + ":库存数量不够");
            } else {
                int count = item.getInventory().getCount();
                int lockCount = item.getInventory().getLockedCount();
                item.getInventory().setCount(count - n.getPurchaseCount());
                item.getInventory().setLockedCount(lockCount + n.getPurchaseCount());
                productRepo.saveAndFlush(item);
            }
        }
    }

    @Override
    public Order paidOrder(int id, String orderStatus) {
        Order order = orderRepo.getOne(id);
        order.setStatus(orderStatus);
        try {
            order.setPaidTime(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orderRepo.save(order);
        LogisticsRecord logisticsRecord = new LogisticsRecord();
        logisticsRecord.setLogisticsStatus("readyToShip");
        logisticsRecord.setOrder(order);
        logisticsRecord.setDeliveryMan("李师傅");
        logisticsRecordRepo.save(logisticsRecord);
        return order;
    }

    @Override
    public Order withdrawnOrder(int id, String orderStatus) {
        Order order = orderRepo.getOne(id);
        order.setStatus(orderStatus);
        try {
            order.setWithdrawnTime(dateFormat.parse(dateFormat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return orderRepo.save(order);
    }

    @Override
    @Transactional
    public void unlockProductCount(int id) {
        Set<OrderProduct> orderProducts = orderRepo.getOne(id).getPurchaseItemList();
        for (OrderProduct n : orderProducts) {
            Product item = productRepo.findById(n.getProductId());
            int count = item.getInventory().getCount();
            int lockCount = item.getInventory().getLockedCount();
            item.getInventory().setCount(count + n.getPurchaseCount());
            item.getInventory().setLockedCount(lockCount - n.getPurchaseCount());
            productRepo.saveAndFlush(item);
        }
    }

    @Override
    @Transactional
    public void finishOrder(int orderId) {
        Order order = orderRepo.getOne(orderId);
        order.setStatus("finished");
        Set<OrderProduct> orderProducts = order.getPurchaseItemList();
        for (OrderProduct n : orderProducts) {
            Product item = productRepo.findById(n.getProductId());
            int lockCount = item.getInventory().getLockedCount();
            item.getInventory().setLockedCount(lockCount - n.getPurchaseCount());
            productRepo.saveAndFlush(item);
        }
    }

    @Override
    public List<Order> getOrders(int userId) {
        return orderRepo.findByUserId(userId);
    }
}
