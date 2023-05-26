package com.example.mysql.mapper.review;


import com.example.domain.review.Like;
import com.example.mysql.entity.review.LikeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface LikeMapper {
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    Like toDomain(LikeEntity likeEntity);

    LikeEntity toEntity(Like like);
}
