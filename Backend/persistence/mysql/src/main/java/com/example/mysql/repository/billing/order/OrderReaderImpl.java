package com.example.mysql.repository.billing.order;

import com.example.domain.billing.order.Order;
import com.example.mysql.mapper.billing.order.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrderReaderImpl implements OrderReader {
    private final OrderEntityRepository orderEntityRepository;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;

    @Override
    public Order findByOrderId(Long orderId) {
        return orderMapper.toDomain(orderEntityRepository.findById(orderId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderEntityRepository.findByUserId(userId).stream()
                .map(orderMapper::toDomain)
                .collect(Collectors.toList());
    }
}
