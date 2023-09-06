package com.example.mysql.entity.auth;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Table(name="auths")
@Getter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uid;
    @Column(nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    //@Enumerated(EnumType.STRING)
    private String provider;
    private  String encryptedPassword;

    @Column(nullable = false)
    private Instant createdDt;
    @Column(nullable = false)
    private Instant updatedDt;

    @PrePersist
    void preInsert() {
        Instant now = Instant.now();
        if (Objects.isNull(this.createdDt)) {
            this.createdDt = now;
        }
        if (Objects.isNull(this.updatedDt)) {
            this.updatedDt = now;
        }
    }

    @PreUpdate
    void preUpdate() {
        this.updatedDt = Instant.now();
    }



}
