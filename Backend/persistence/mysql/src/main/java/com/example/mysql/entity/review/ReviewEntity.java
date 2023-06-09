package com.example.mysql.entity.review;

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

@Table(name = "reviews")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private Long postId;
    private String photoUrl;

    @Column(nullable = false)
    private Integer rate;
    @Column(nullable = false)
    private String comment;

    @CreationTimestamp
    private Instant createdDt;
    @UpdateTimestamp
    private Instant updatedDt;
}
