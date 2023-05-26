package com.example.mysql.repository.product;


import com.example.domain.product.Product;

import java.util.List;

public interface ProductReader {
    Product findByProductId(Long productId);

    List<Product> findAll();
}
