package com.example.mysql.repository.product;

import com.example.domain.product.Product;
import com.example.mysql.entity.product.ProductEntity;
import com.example.mysql.entity.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductReaderImpl implements ProductReader {
    private final ProductEntityRepository productEntityRepository;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Override
    public Product findByProductId(Long productId) {
        ProductEntity productEntity = productEntityRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);
        return productMapper.toDomain(productEntity);
    }

    @Override
    public List<Product> findAll() {
        return productEntityRepository.findAll().stream()
                .map(productMapper::toDomain)
                .collect(Collectors.toList());
    }
}
