package com.example.entity.billing.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Table(name="payments")
@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Long paymentId;

    @Column(name="user_id")
    private Long userId;
    @Column(name="shop_id")
    private Long shopId;
    @Column(name="money")
    private Integer money;

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
