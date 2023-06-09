package com.example.mysql.repository.product.writer;

import com.example.domain.product.Product;
import com.example.mysql.mapper.product.ProductMapper;
import com.example.mysql.repository.product.jpa.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductWriterImpl implements ProductWriter {
    private final ProductEntityRepository productEntityRepository;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public Product create(Product product) {
        return productMapper.toDomain(productEntityRepository.save(productMapper.toEntity(product)));
    }
}
