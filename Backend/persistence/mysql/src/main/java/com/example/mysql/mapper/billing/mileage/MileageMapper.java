package com.example.mysql.mapper.billing.mileage;

import com.example.domain.billing.mileage.Mileage;
import com.example.mysql.entity.billing.mileage.MileageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MileageMapper {
    MileageMapper INSTANCE = Mappers.getMapper(MileageMapper.class);

    Mileage toDomain(MileageEntity mileageEntity);

    MileageEntity toEntity(Mileage mileage);
}
