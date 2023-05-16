package com.example.repository.billing.mileage;

import com.example.entity.billing.mileage.MileageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileageEntityRepository extends JpaRepository<MileageEntity, Long> {
}
