package com.example.domain.photo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    private Long photoId;

    private String encodedName;
    private String originalName;
    private String path;
    private String fileExtension;

    private Instant createdDt;
    private Instant updatedDt;
}
