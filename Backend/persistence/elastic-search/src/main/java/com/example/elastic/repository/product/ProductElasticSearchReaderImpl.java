package com.example.elastic.repository.product;

import com.example.domain.product.Product;
import com.example.elastic.document.product.ProductDocument;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductElasticSearchReaderImpl implements ProductElasticSearchReader {
    private final ElasticsearchOperations elasticsearchOperations;

    public List<Product> search(String query){
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.boolQuery()
                        .should(QueryBuilders.matchQuery("productName", query)).boost(40.0f)
                );
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(PageRequest.of(0, 10))
                .build();
        List<Product> products = elasticsearchOperations.search(searchQuery, ProductDocument.class, elasticsearchOperations.getIndexCoordinatesFor(ProductDocument.class))
                .stream()
                .map(SearchHit::getContent)
                .map(pd -> Product.builder()
                        .productId(Long.valueOf(pd.getId()))
                        .productName(pd.getProductName())
                        .build())
                .collect(Collectors.toList());
        return products;
    }

}
