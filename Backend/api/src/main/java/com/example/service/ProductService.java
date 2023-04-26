package com.example.service;

import com.example.mysql.domain.product.Product;
import com.example.mysql.repository.product.ProductReader;
import com.example.mysql.repository.product.ProductWriter;
import com.example.request.product.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductWriter productWriter;
    private final ProductReader productReader;

    @Transactional(value = "productTransactionManager")
    public Product createProduct(CreateProductRequest request) {
        Product product = Product.builder()
                .productName(request.getProductName())
                .build();
        return productWriter.create(product);
    }

    @Transactional(value = "productTransactionManager")
    public Product findByProductId(Long productId) {
        return productReader.findByProductId(productId);
    }
}
