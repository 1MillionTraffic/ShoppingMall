package com.example.repository.billing.order;

import com.example.domain.billing.order.Order;

public interface OrderWriter {
    Order create(Order order);
}
