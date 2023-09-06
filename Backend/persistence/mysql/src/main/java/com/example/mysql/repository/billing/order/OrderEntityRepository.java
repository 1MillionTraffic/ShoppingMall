package com.example.mysql.repository.billing.order;

import com.example.mysql.entity.billing.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByUserId(Long userId);
}
