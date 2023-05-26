package com.example.mysql.repository.photo.reader;

import com.example.domain.photo.Photo;

public interface PhotoReader {
    Photo findByPhotoId(Long photoId);
}
