package com.example.mysql.mapper.product;

import com.example.domain.product.Category;
import com.example.mysql.entity.product.CategoryEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toDomain(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.categoryId( categoryEntity.getCategoryId() );

        return category.build();
    }

    @Override
    public CategoryEntity toEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.categoryId( category.getCategoryId() );

        return categoryEntity.build();
    }
}
