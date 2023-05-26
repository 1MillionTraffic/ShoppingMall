package com.example.mysql.repository.product.writer;


import com.example.domain.product.Product;

public interface ProductWriter {
    Product create(Product product);
}
