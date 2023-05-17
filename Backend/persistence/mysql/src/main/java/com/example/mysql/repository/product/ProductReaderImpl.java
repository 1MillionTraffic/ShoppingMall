package com.example.mysql.repository.product;

import com.example.mysql.domain.product.Product;
import com.example.mysql.entity.product.ProductEntity;
import com.example.mysql.entity.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
