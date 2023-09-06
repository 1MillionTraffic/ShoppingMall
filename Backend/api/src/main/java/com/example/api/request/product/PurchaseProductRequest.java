package com.example.api.request.product;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProductRequest {
    private Long productId;
    private Integer quantity;
    private Long optionId;
}
