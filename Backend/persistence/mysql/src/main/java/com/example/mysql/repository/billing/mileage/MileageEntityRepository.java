package com.example.mysql.repository.billing.mileage;

import com.example.mysql.entity.billing.mileage.MileageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileageEntityRepository extends JpaRepository<MileageEntity, Long> {
}
