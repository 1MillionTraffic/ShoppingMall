package com.example.mysql.repository.billing.mileage;


import com.example.domain.billing.mileage.Mileage;

public interface MileageWriter {
    Mileage create(Mileage mileage);

}
