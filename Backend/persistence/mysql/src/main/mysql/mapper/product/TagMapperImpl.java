package com.example.mysql.mapper.product;

import com.example.mysql.domain.product.Tag;
import com.example.mysql.entity.product.TagEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag toDomain(TagEntity tagEntity) {
        if ( tagEntity == null ) {
            return null;
        }

        Tag.TagBuilder tag = Tag.builder();

        tag.tagId( tagEntity.getTagId() );

        return tag.build();
    }

    @Override
    public TagEntity toEntity(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagEntity.TagEntityBuilder tagEntity = TagEntity.builder();

        tagEntity.tagId( tag.getTagId() );

        return tagEntity.build();
    }
}
