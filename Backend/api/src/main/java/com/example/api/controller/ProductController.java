package com.example.api.controller;

import com.example.api.request.product.CreateProductRequest;
import com.example.api.request.product.PurchaseProductRequest;
import com.example.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductRequest request) {
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findById(@PathVariable("productId") Long productId) {
        return new ResponseEntity<>(productService.findByProductId(productId), HttpStatus.OK);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody PurchaseProductRequest req){
        var purchaseResponse = productService.purchase(req.getProductId(), req.getOptionId(), req.getQuantity());
        return new ResponseEntity<>(purchaseResponse, HttpStatus.OK);
    }
}
