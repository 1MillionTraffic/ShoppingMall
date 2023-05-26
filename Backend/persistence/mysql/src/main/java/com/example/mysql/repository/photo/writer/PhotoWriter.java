package com.example.mysql.repository.photo.writer;

import com.example.mysql.domain.photo.Photo;

public interface PhotoWriter {
    Photo create(Photo product);
}
