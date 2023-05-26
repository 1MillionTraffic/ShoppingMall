package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopEntityRepository extends JpaRepository<ShopEntity, Long> {
}
