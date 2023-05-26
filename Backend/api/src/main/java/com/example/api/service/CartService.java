package com.example.api.service;

import com.example.mongodb.repository.CartReader;
import com.example.mongodb.repository.CartWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartReader cartReader;
    private final CartWriter cartWriter;

}
