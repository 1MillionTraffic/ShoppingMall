package com.example.entity.billing.mileage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Table(name="mileages")
@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MileageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mileage_id")
    private Long mileageId;
    @Column(name="order_id")
    private Long orderId;
    @Column(name="userId")
    private Long userId;
    @Column(name="mileage")
    private Integer mileage;

    @Column(name="created_dt")
    private Instant createdDt;
    @Column(name="updated_dt")
    private Instant updatedDt;
    @PrePersist
    public void prePersist(){
        this.createdDt = Instant.now();
        this.updatedDt = Instant.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedDt = Instant.now();
    }
}
