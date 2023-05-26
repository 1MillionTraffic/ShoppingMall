package com.example.entity.auth;


import com.example.domain.auth.Auth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Table(name="auth")
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
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private String provider;
    private @Nullable String encryptedPassword;

    @Column(nullable = false)
    private Instant createDt;
    @Column(nullable = false)
    private Instant updateDt;

    @PrePersist
    void preInsert() {
        Instant now = Instant.now();
        if (Objects.isNull(this.createDt)) {
            this.createDt = now;
        }
        if (Objects.isNull(this.updateDt)) {
            this.updateDt = now;
        }
    }

    @PreUpdate
    void preUpdate() {
        this.updateDt = Instant.now();
    }


    public static AuthEntity of(Auth auth){
        return AuthEntity.builder()
                .id(auth.getId())
                .uid(auth.getUid())
                .email(auth.getEmail())
                .provider(auth.getProvider())
                .build();
    }
}
