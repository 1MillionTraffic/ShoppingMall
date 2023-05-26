package com.example.controller;

import com.example.response.product.ProductResponse;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/batch/products")
@RestController
@RequiredArgsConstructor
public class ProductBatchController {
    private final ProductService productService;

    @PostMapping
    public void insert(){
        productService.esInsert();
    }

    @GetMapping
    public List<ProductResponse> find(@RequestParam("query") String query){
        return productService.findQuery(query).stream().map(p -> ProductResponse.builder()
                .productId(p.getProductId())
                .productName(p.getProductName())
                .build())
                .collect(Collectors.toList());
    }
}
