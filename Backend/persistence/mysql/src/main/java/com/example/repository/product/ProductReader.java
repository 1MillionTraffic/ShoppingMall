package com.example.repository.product;

import com.example.domain.product.Product;

public interface ProductReader {
    Product findByProductId(Long productId);
}
