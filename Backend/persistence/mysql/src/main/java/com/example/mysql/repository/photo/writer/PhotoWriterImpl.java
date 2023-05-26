package com.example.mysql.repository.photo.writer;

import com.example.domain.photo.Photo;
import com.example.mysql.mapper.photo.PhotoMapper;
import com.example.mysql.repository.photo.jpa.PhotoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PhotoWriterImpl implements PhotoWriter {
    private final PhotoEntityRepository photoEntityRepository;
    private final PhotoMapper photoMapper = PhotoMapper.INSTANCE;

    public Photo create(Photo product) {
        return photoMapper.toDomain(photoEntityRepository.save(photoMapper.toEntity(product)));
    }

}
