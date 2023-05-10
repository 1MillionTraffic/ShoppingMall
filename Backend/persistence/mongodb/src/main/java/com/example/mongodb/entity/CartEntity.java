package com.example.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Document(collection = "cart")
public class CartEntity {
    @MongoId
    private String id;
    private Long userId;
    private List<Long> productList = Collections.emptyList();

    private Instant createDt = Instant.now();
    private Instant updateDt = Instant.now();
}
