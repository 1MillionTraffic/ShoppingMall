package com.example.repository.billing.order;

import com.example.domain.billing.order.Order;
import com.example.entity.billing.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderWriterImpl implements OrderWriter{
    private final OrderEntityRepository orderEntityRepository;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;
    @Override
    public Order create(Order order) {
        return orderMapper.toDomain(orderEntityRepository.save(orderMapper.toEntity(order)));
    }
}
