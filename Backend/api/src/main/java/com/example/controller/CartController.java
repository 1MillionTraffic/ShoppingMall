package com.example.controller;

import com.example.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @RequestMapping("/test")
    public Object test() {
        cartService.save();
        return cartService.findAll();
    }

}
