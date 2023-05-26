package com.example.mysql.repository.review.reader;

import com.example.mysql.domain.review.Review;

public interface ReviewReader {
    Review findByPostId(Long postId);
}
