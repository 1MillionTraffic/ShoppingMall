package com.example.job;

import com.example.repository.product.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ElasticSearchJob {
    private final ProductReader productReader;
    private final ElasticsearchOperations elasticsearchOperations;

    @Scheduled
    public void job(){


    }
}
