package com.example.mysql.mapper.product;

import com.example.domain.product.Post;
import com.example.mysql.entity.product.PostEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:51+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toDomain(PostEntity postEntity) {
        if ( postEntity == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.postId( postEntity.getPostId() );

        return post.build();
    }

    @Override
    public PostEntity toEntity(Post post) {
        if ( post == null ) {
            return null;
        }

        PostEntity.PostEntityBuilder postEntity = PostEntity.builder();

        postEntity.postId( post.getPostId() );

        return postEntity.build();
    }
}
