package com.example.mysql.repository.billing.order;

import com.example.mysql.entity.billing.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
}
