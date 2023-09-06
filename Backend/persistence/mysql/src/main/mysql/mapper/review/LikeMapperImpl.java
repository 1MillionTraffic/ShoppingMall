package com.example.mysql.mapper.review;

import com.example.domain.review.Like;
import com.example.mysql.entity.review.LikeEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class LikeMapperImpl implements LikeMapper {

    @Override
    public Like toDomain(LikeEntity likeEntity) {
        if ( likeEntity == null ) {
            return null;
        }

        Like.LikeBuilder like = Like.builder();

        like.likeId( likeEntity.getLikeId() );

        return like.build();
    }

    @Override
    public LikeEntity toEntity(Like like) {
        if ( like == null ) {
            return null;
        }

        LikeEntity.LikeEntityBuilder likeEntity = LikeEntity.builder();

        likeEntity.likeId( like.getLikeId() );

        return likeEntity.build();
    }
}
