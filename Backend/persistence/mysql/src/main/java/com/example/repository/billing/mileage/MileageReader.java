package com.example.repository.billing.mileage;

import com.example.domain.billing.mileage.Mileage;

public interface MileageReader {

    Mileage findByMileageId(Long mileageId);

}
