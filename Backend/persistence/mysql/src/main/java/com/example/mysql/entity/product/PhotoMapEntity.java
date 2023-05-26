package com.example.mysql.entity.product;

import com.example.mysql.enums.PhotoRefType;
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

@Table(name = "photo_map")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoMapEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoMapId;

    @Column(nullable = false)
    private Long refId;
    @Column(nullable = false)
    private String photoUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PhotoRefType refType;

    @CreationTimestamp
    private Instant createdDt;
    @UpdateTimestamp
    private Instant updatedDt;
}
