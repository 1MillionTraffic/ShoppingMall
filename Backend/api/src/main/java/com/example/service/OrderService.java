package com.example.service;

import com.example.domain.billing.order.Order;
import com.example.repository.billing.order.OrderReader;
import com.example.repository.billing.order.OrderWriter;
import com.example.request.order.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderWriter orderWriter;
    private final OrderReader orderReader;

    @Transactional(value = "billingTransactionManager")
    public Order createOrder(CreateOrderRequest request){
        return orderWriter.create(request.toDomain());
    }

    @Transactional(value = "billingTransactionManager")
    public Order findByOrderId(Long orderId){
        return orderReader.findByOrderId(orderId);
    }
}
