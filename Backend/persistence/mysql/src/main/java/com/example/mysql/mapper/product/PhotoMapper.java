package com.example.mysql.mapper.product;


import com.example.mysql.domain.product.Photo;
import com.example.mysql.entity.product.PhotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PhotoMapper {
    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    Photo toDomain(PhotoEntity photoEntity);

    PhotoEntity toEntity(Photo photo);
}
