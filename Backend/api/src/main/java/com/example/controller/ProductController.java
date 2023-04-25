package com.example.controller;

import com.example.request.product.CreateProductRequest;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductRequest request){
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findById(@PathVariable("productId") Long productId){
        return new ResponseEntity<>(productService.findByProductId(productId), HttpStatus.OK);
    }
}
