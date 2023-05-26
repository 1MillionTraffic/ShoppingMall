package com.example.mongodb.repository;

import com.example.mongodb.document.CartDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<CartDocument, String> {
}
