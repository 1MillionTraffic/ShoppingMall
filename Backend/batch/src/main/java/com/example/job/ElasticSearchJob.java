package com.example.job;

import com.example.mysql.domain.product.Product;
import com.example.mysql.repository.product.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ElasticSearchJob {
    private final ProductReader productReader;
    private final ElasticsearchOperations elasticsearchOperations;

    private boolean createIndex(Class<?> cls) throws IOException{
        IndexOperations indexOperations = elasticsearchOperations.indexOps(cls);
        return indexOperations.createWithMapping();
    }

    @Scheduled
    public void job() throws Exception {
        // batch bulk read and write ?
        for(Product product : productReader.findAll()){
            IndexCoordinates indexCoordinates = elasticsearchOperations.getIndexCoordinatesFor(Product.class);
            IndexOperations indexOperations = elasticsearchOperations.indexOps(indexCoordinates);

            if(!indexOperations.exists()){
                if(!createIndex(Product.class)){
                    throw new Exception("");
                }
            }

            IndexQuery indexQuery = new IndexQueryBuilder()
                    .withId(product.getProductId().toString())
                    .withObject(product)
                    .build();
            elasticsearchOperations.index(indexQuery, indexCoordinates);
        }
    }
}
