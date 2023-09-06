package com.example.api.response.product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseResponse {
    private Long productId;
    private int quantity;
    private Long OptionId;
    private Boolean Success;
}
