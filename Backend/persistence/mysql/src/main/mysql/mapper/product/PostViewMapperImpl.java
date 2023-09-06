package com.example.mysql.mapper.product;

import com.example.mysql.domain.product.PostView;
import com.example.mysql.entity.product.PostViewEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class PostViewMapperImpl implements PostViewMapper {

    @Override
    public PostView toDomain(PostViewEntity postViewEntity) {
        if ( postViewEntity == null ) {
            return null;
        }

        PostView.PostViewBuilder postView = PostView.builder();

        postView.postViewId( postViewEntity.getPostViewId() );

        return postView.build();
    }

    @Override
    public PostViewEntity toEntity(PostView postView) {
        if ( postView == null ) {
            return null;
        }

        PostViewEntity.PostViewEntityBuilder postViewEntity = PostViewEntity.builder();

        postViewEntity.postViewId( postView.getPostViewId() );

        return postViewEntity.build();
    }
}
