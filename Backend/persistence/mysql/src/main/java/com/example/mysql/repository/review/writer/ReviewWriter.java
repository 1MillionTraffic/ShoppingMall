package com.example.mysql.repository.review.writer;

import com.example.mysql.domain.review.Review;

public interface ReviewWriter {
    Review create(Review product);
}
