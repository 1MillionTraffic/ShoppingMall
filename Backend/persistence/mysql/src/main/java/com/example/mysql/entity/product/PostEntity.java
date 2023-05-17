package com.example.mysql.entity.product;

import com.example.mysql.enums.PostState;
import com.example.mysql.enums.PostType;
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

@Table(name = "posts")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long thumbnailPhotoId;

    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content; // html

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostType postType; // 글 종류

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostState postState;  // 글 상태

    @CreationTimestamp
    private Instant createdDt;
    @UpdateTimestamp
    private Instant updatedDt;
}
