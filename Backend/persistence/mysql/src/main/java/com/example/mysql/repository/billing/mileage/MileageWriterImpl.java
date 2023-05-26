package com.example.mysql.repository.billing.mileage;

import com.example.domain.billing.mileage.Mileage;
import com.example.mysql.mapper.billing.mileage.MileageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MileageWriterImpl implements MileageWriter {
    private final MileageEntityRepository mileageEntityRepository;
    private final MileageMapper mileageMapper = MileageMapper.INSTANCE;

    @Override
    public Mileage create(Mileage mileage) {
        return mileageMapper.toDomain(mileageEntityRepository.save(mileageMapper.toEntity(mileage)));
    }
}
