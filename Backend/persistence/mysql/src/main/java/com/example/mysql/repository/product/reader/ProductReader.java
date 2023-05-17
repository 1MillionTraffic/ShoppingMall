package com.example.mysql.repository.product.reader;

import com.example.mysql.domain.product.Product;

public interface ProductReader {
    Product findByProductId(Long productId);
}
