package com.example.mongodb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Document(collection = "cart")
public class Cart {
    private String id;
    private Long userId;
    private List<Long> productList = Collections.emptyList();

    private Instant createDt = Instant.now();
    private Instant updateDt = Instant.now();
}
