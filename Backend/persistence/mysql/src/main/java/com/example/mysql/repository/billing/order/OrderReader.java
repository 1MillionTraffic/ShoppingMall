package com.example.mysql.repository.billing.order;


import com.example.domain.billing.order.Order;

import java.util.List;

public interface OrderReader {
    Order findByOrderId(Long orderId);
    List<Order> findByUserId(Long userId);
}
