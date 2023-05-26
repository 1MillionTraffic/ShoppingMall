package com.example.mysql.repository.review.reader;

import com.example.mysql.domain.review.Review;
import com.example.mysql.entity.review.ReviewEntity;
import com.example.mysql.mapper.review.ReviewMapper;
import com.example.mysql.repository.review.jpa.ReviewEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewReaderImpl implements ReviewReader {
    private final ReviewEntityRepository reviewEntityRepository;
    private final ReviewMapper reviewMapper = ReviewMapper.INSTANCE;

    @Override
    public Review findByPostId(Long postId) {
        ReviewEntity reviewEntity = reviewEntityRepository.findByPostId(postId)
                .orElseThrow(IllegalArgumentException::new);
        return reviewMapper.toDomain(reviewEntity);
    }
}
