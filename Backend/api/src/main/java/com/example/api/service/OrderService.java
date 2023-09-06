package com.example.api.service;

import com.example.api.request.order.CreateOrderRequest;
import com.example.domain.billing.order.Order;
import com.example.mysql.repository.billing.order.OrderReader;
import com.example.mysql.repository.billing.order.OrderWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderWriter orderWriter;
    private final OrderReader orderReader;

    @Transactional(value = "billingTransactionManager")
    public Order createOrder(CreateOrderRequest request) {
        return orderWriter.create(request.toDomain());
    }

    @Transactional(value = "billingTransactionManager")
    public Order findByOrderId(Long orderId) {
        return orderReader.findByOrderId(orderId);
    }

    public List<Order> findByUserId(Long userId) {return orderReader.findByUserId(userId);}
}
