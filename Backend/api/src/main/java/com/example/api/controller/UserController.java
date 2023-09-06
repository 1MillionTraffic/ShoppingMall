package com.example.api.controller;

import com.example.api.annotation.auth.Auth;
import com.example.api.model.enums.AuthorizationMode;
import com.example.api.service.CartService;
import com.example.api.service.OrderService;
import com.example.api.service.PaymentService;
import com.example.api.service.UserService;
import com.example.domain.billing.order.Order;
import com.example.domain.billing.payment.Payment;
import com.example.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<?> myPage(@Auth User user){
            var userId = user.getUserId();
            List<Payment> paymentInfo = paymentService.findByUserId(userId);
            List<Order> orderInfo = orderService.findByUserId(userId);

            return null;
    }

    @GetMapping("/test")
    public ResponseEntity<?> testDefaultAuthentication(@Auth User user){
        return new ResponseEntity<>(user.getEmail(), HttpStatus.OK);
    }

    @GetMapping("/vendor")
    public ResponseEntity<?> testVendorAuthentication(
            @Auth(authorizationMode = AuthorizationMode.VENDOR_ONLY) User user){
        return new ResponseEntity<>(user.getEmail(), HttpStatus.OK);
    }

}
