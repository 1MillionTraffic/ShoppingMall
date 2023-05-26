package com.example.elastic.repository.product;

import com.example.domain.product.Product;
import com.example.elastic.document.product.ProductDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductElasticSearchWriterImpl implements ProductElasticSearchWriter {
    private final ElasticsearchOperations elasticsearchOperations;
    public void bulkIndex(List<Product> products){
        List<IndexQuery> indexQueries = new ArrayList<>();
        for(Product product : products){
            IndexQuery indexQuery = new IndexQueryBuilder()
                    .withId(product.getProductId().toString())
                    .withObject(ProductDocument.builder()
                            .id(product.getProductId().toString())
                            .productName(product.getProductName())
                            .build())
                    .build();
            indexQueries.add(indexQuery);
        }
        elasticsearchOperations.bulkIndex(indexQueries, elasticsearchOperations.getIndexCoordinatesFor(ProductDocument.class));
    }
}
