package com.example.mysql.repository.review.writer;

import com.example.mysql.domain.review.Review;
import com.example.mysql.mapper.review.ReviewMapper;
import com.example.mysql.repository.review.jpa.ReviewEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewWriterImpl implements ReviewWriter {
    private final ReviewEntityRepository reviewEntityRepository;
    private final ReviewMapper reviewMapper = ReviewMapper.INSTANCE;

    @Override
    public Review create(Review review) {
        return reviewMapper.toDomain(reviewEntityRepository.save(reviewMapper.toEntity(review)));
    }
}
