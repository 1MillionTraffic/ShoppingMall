package com.example.mysql.repository.product.writer;

import com.example.mysql.domain.product.Product;

public interface ProductWriter {
    Product create(Product product);
}
