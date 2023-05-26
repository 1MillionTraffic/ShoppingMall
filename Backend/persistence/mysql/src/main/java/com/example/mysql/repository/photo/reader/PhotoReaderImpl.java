package com.example.mysql.repository.photo.reader;

import com.example.mysql.domain.photo.Photo;
import com.example.mysql.mapper.photo.PhotoMapper;
import com.example.mysql.repository.photo.jpa.PhotoEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PhotoReaderImpl implements PhotoReader {
    private final PhotoEntityRepository photoEntityRepository;
    private final PhotoMapper photoMapper = PhotoMapper.INSTANCE;


    @Override
    public Photo findByPhotoId(Long photoId) {
        return photoMapper.toDomain(photoEntityRepository.findById(photoId).orElseThrow());
    }
}
