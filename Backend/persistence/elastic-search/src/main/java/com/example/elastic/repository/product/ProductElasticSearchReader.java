package com.example.elastic.repository.product;

import com.example.domain.product.Product;

import java.util.List;

public interface ProductElasticSearchReader {
    List<Product> search(String query);
}
