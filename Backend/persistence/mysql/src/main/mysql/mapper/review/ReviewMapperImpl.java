package com.example.mysql.mapper.review;

import com.example.domain.review.Review;
import com.example.mysql.entity.review.ReviewEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toDomain(ReviewEntity reviewEntity) {
        if ( reviewEntity == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.reviewId( reviewEntity.getReviewId() );

        return review.build();
    }

    @Override
    public ReviewEntity toEntity(Review product) {
        if ( product == null ) {
            return null;
        }

        ReviewEntity.ReviewEntityBuilder reviewEntity = ReviewEntity.builder();

        reviewEntity.reviewId( product.getReviewId() );

        return reviewEntity.build();
    }
}
