package com.example.mysql.mapper.product;


import com.example.mysql.domain.product.Tag;
import com.example.mysql.entity.product.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    Tag toDomain(TagEntity tagEntity);

    TagEntity toEntity(Tag tag);
}
