package com.example.mysql.mapper.product;


import com.example.mysql.domain.product.Like;
import com.example.mysql.entity.product.LikeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface LikeMapper {
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    Like toDomain(LikeEntity likeEntity);

    LikeEntity toEntity(Like like);
}
