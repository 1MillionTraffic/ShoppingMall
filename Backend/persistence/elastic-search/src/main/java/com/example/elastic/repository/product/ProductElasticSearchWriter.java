package com.example.elastic.repository.product;

import com.example.domain.product.Product;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import java.util.List;

public interface ProductElasticSearchWriter {
    void bulkIndex(List<Product> products);

}
