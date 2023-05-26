package com.example.mysql.repository.billing.order;


import com.example.domain.billing.order.Order;

public interface OrderReader {
    Order findByOrderId(Long orderId);
}
