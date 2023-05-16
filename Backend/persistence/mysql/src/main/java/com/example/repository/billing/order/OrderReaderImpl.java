package com.example.repository.billing.order;

import com.example.domain.billing.order.Order;
import com.example.entity.billing.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderReaderImpl implements OrderReader{
    private final OrderEntityRepository orderEntityRepository;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;
    @Override
    public Order findByOrderId(Long orderId) {
        return orderMapper.toDomain(orderEntityRepository.findById(orderId).orElseThrow(IllegalArgumentException::new));
    }
}
