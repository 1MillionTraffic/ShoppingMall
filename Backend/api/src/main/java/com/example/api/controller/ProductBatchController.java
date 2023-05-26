package com.example.api.controller;

import com.example.api.response.product.ProductResponse;
import com.example.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/batch/products")
@RestController
@RequiredArgsConstructor
public class ProductBatchController {
    private final ProductService productService;

    @PostMapping
    public void insert() {
        productService.esInsert();
    }

    @GetMapping
    public List<ProductResponse> find(@RequestParam("query") String query) {
        return productService.findQuery(query).stream().map(p -> ProductResponse.builder()
                        .productId(p.getProductId())
                        .productName(p.getProductName())
                        .build())
                .collect(Collectors.toList());
    }
}
