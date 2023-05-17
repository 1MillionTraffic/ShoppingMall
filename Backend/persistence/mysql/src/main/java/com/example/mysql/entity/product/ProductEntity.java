package com.example.mysql.entity.product;

import com.example.mysql.enums.Gender;
import com.example.mysql.enums.ProductState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

/**
 * option(재고, 사이즈) 테이블  v
 * 게시글 테이블               v
 * 조회수 테이블               v
 * 좋아요 테이블               v
 * 리뷰(별점) 테이블           v
 * 누적 판매량 테이블           v
 * tag(판매처 태그) 테이블      v
 * sale 테이블               v
 */
@Table(name = "products")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false)
    private Long shopId;
    private Long saleId;

    @Column(nullable = false)
    private Long thumbnailPhotoId; // 대표 이미지

    @Column(nullable = false)
    private Long categoryId;
    private Long subCategoryId;
    @Column(nullable = false)
    private String serialNumber; // 판매처에서 관리하는 ID

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductState productState;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String productDesc;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private long price; // default price
    private Instant registerDt;

    @CreationTimestamp
    private Instant createdDt;
    @UpdateTimestamp
    private Instant updatedDt;
}
