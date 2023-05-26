package com.example.entity.user;

import com.example.domain.user.User;
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
    private String uid;

    @Column
    private String userName;

    @Column
    private String email;


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


    public static UserEntity of(User user){
        return UserEntity.builder()
                .userId(user.getUserId())
                .uid(user.getUid())
                .email(user.getEmail())
                .userName(user.getUserName())
                .build();
    }
}
