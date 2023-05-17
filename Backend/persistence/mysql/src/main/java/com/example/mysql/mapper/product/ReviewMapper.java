package com.example.mysql.mapper.product;


import com.example.mysql.domain.product.Review;
import com.example.mysql.entity.product.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review toDomain(ReviewEntity reviewEntity);

    ReviewEntity toEntity(Review review);
}
