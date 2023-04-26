package com.example.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Table(name="users")
@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column
    private String userName;


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
