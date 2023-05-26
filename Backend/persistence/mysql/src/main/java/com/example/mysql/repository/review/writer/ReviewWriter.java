package com.example.mysql.repository.review.writer;

import com.example.domain.review.Review;

public interface ReviewWriter {
    Review create(Review product);
}
