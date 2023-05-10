package com.example.mongodb.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
@Builder
public class Cart {
    private String id;
    private final Long userId;
    @Builder.Default
    private final List<Long> productList = Collections.emptyList();
}
