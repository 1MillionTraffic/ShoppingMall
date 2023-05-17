package com.example.mysql.mapper.product;


import com.example.mysql.domain.product.PostView;
import com.example.mysql.entity.product.PostViewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PostViewMapper {
    PostViewMapper INSTANCE = Mappers.getMapper(PostViewMapper.class);

    PostView toDomain(PostViewEntity postViewEntity);

    PostViewEntity toEntity(PostView postView);
}
