package com.example.mysql.mapper.product;


import com.example.domain.product.Post;
import com.example.mysql.entity.product.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post toDomain(PostEntity postEntity);

    PostEntity toEntity(Post post);
}
