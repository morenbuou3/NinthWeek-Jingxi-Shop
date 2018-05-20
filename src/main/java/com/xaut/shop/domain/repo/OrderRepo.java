package com.xaut.shop.domain.repo;

import com.xaut.shop.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Order findById(int id);
}
