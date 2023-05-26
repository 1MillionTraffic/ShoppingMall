package com.example.mysql.mapper.photo;


import com.example.mysql.domain.photo.Photo;
import com.example.mysql.entity.photo.PhotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PhotoMapper {
    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    Photo toDomain(PhotoEntity photoEntity);

    PhotoEntity toEntity(Photo photo);
}
