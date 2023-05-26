package com.example.mysql.mapper.review;


import com.example.mysql.domain.review.Review;
import com.example.mysql.entity.review.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review toDomain(ReviewEntity reviewEntity);

    ReviewEntity toEntity(Review product);
}
