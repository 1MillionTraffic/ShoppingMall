package com.example.mongodb.repository;

import com.example.mongodb.entity.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartReaderImpl implements CartReader {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper = CartMapper.INSTANCE;

}
