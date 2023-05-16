package com.example.repository.billing.mileage;

import com.example.domain.billing.mileage.Mileage;
import com.example.entity.billing.mileage.MileageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MileageReaderImpl implements MileageReader{
    private final MileageEntityRepository mileageEntityRepository;
    private final MileageMapper mileageMapper = MileageMapper.INSTANCE;
    @Override
    public Mileage findByMileageId(Long mileageId) {
        return mileageMapper.toDomain(mileageEntityRepository.findById(mileageId).orElseThrow(IllegalArgumentException::new));
    }
}
