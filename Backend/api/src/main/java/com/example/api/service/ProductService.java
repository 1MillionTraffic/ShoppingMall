package com.example.api.service;

import com.example.api.request.product.CreateProductRequest;
import com.example.domain.product.Product;
import com.example.elastic.repository.product.ProductElasticSearchReader;
import com.example.elastic.repository.product.ProductElasticSearchWriter;
import com.example.mysql.repository.product.reader.ProductReader;
import com.example.mysql.repository.product.writer.ProductWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductWriter productWriter;
    private final ProductReader productReader;
    private final ProductElasticSearchReader productElasticSearchReader;
    private final ProductElasticSearchWriter productElasticSearchWriter;

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

    public void esInsert() {
        productElasticSearchWriter.bulkIndex(productReader.findAll());
    }

    public List<Product> findQuery(String query) {
        return productElasticSearchReader.search(query);
    }
}
