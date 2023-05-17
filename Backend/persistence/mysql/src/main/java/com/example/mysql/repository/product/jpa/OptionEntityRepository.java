package com.example.mysql.repository.product.jpa;

import com.example.mysql.entity.product.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionEntityRepository extends JpaRepository<OptionEntity, Long> {
}
