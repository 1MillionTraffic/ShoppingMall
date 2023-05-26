package com.example.elastic.document.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Builder
@AllArgsConstructor
@Document(indexName = "product")
public class ProductDocument {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String productName;
}
