package com.example.repository.product;

import com.example.domain.product.Product;

public interface ProductWriter {
    Product create(Product product);
}
