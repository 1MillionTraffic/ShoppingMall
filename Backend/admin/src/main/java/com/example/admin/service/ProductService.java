package com.example.admin.service;

import com.example.admin.request.product.CreateProductRequest;
import com.example.domain.product.Product;
import com.example.mysql.repository.product.reader.ProductReader;
import com.example.mysql.repository.product.writer.ProductWriter;
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

}
