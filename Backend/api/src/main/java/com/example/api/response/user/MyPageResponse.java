package com.example.api.response.user;

import com.example.api.response.order.OrderResponse;
import com.example.api.response.payment.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MyPageResponse {
    UserResponse user;
    List<OrderResponse> orders;
    List<PaymentResponse> payments;

}
