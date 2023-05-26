package com.example.mysql.entity.billing.order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Table(name="orders")
@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long orderId;

    @Column(name="user_id")
    private Long userId;
    @Column(name="product_id")
    private Long productId;
    @Column(name="product_option_id")
    private Long productOptionId;

    @Column(name="product_name")
    private String productName;
    @Column(name="shop_name")
    private String shopName;
    @Column(name="price")
    private Integer price;
    @Column(name="quantity")
    private Integer quantity;
    @Column(name="product_option_name")
    private String productOptionName;

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
