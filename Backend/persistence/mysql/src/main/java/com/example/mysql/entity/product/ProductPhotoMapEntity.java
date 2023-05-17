package com.example.mysql.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Table(name = "product_photo_map")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhotoMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productPhotoMapId;

    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private Long photoId;

    @CreationTimestamp
    private Instant createdDt;
    @UpdateTimestamp
    private Instant updatedDt;
}
