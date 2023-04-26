package com.example.service;

import com.example.mongodb.entity.Cart;
import com.example.mongodb.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;


    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    public void save() {
        Cart cart = new Cart();
        cart.setUserId(1L);
        cart.setProductList(Collections.emptyList());
        cartRepository.save(cart);
    }
}
