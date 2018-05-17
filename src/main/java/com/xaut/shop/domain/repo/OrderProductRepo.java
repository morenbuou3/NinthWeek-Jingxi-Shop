package com.xaut.shop.domain.repo;

import com.xaut.shop.domain.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {
}
