package com.example.mysql.entity.product;

import com.example.mysql.enums.Gender;
import com.example.mysql.enums.ProductState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Table(name = "products")
@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private Long shopId;
    @Column(nullable = false)
    private Long categoryId;
    private Long subCategoryId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductState productState;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String productDesc;
    @Column(nullable = false)
    private String serialNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private long price;
    private Instant registerDt;

    @CreationTimestamp
    private Instant createdDt;
    @UpdateTimestamp
    private Instant updatedDt;
}
