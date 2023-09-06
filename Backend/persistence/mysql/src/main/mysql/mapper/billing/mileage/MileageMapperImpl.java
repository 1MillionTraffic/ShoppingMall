package com.example.mysql.mapper.billing.mileage;

import com.example.domain.billing.mileage.Mileage;
import com.example.mysql.entity.billing.mileage.MileageEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class MileageMapperImpl implements MileageMapper {

    @Override
    public Mileage toDomain(MileageEntity mileageEntity) {
        if ( mileageEntity == null ) {
            return null;
        }

        Mileage.MileageBuilder mileage = Mileage.builder();

        mileage.mileageId( mileageEntity.getMileageId() );
        mileage.userId( mileageEntity.getUserId() );
        mileage.orderId( mileageEntity.getOrderId() );
        mileage.mileage( mileageEntity.getMileage() );

        return mileage.build();
    }

    @Override
    public MileageEntity toEntity(Mileage mileage) {
        if ( mileage == null ) {
            return null;
        }

        MileageEntity.MileageEntityBuilder mileageEntity = MileageEntity.builder();

        mileageEntity.mileageId( mileage.getMileageId() );
        mileageEntity.orderId( mileage.getOrderId() );
        mileageEntity.userId( mileage.getUserId() );
        mileageEntity.mileage( mileage.getMileage() );

        return mileageEntity.build();
    }
}
