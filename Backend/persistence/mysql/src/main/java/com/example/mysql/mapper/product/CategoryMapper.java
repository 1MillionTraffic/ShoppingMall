package com.example.mysql.mapper.product;


import com.example.domain.product.Category;
import com.example.mysql.entity.product.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toDomain(CategoryEntity categoryEntity);

    CategoryEntity toEntity(Category category);
}
