package com.example.admin.service;

import com.example.admin.util.HashUtil;
import com.example.domain.photo.Photo;
import com.example.mysql.repository.photo.writer.PhotoWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.ZonedDateTime;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhotoLocalService implements PhotoService {
    private final PhotoWriter photoWriter;
    @Value("${file.upload-dir}")
    private String filePath;
    @Value("${file.base-url}")
    private String baseUrl;
    @Value("${file.salt}")
    private String salt;


    @PostConstruct
    public void init() {
        // 폴더 생성
        File folder = new File(filePath);
        if (!folder.exists() && !folder.mkdirs()) {
            throw new IllegalStateException("[FileService] fail to make dir: " + filePath);
        }
    }


    @Override
    public String uploadPhoto(MultipartFile file) {
        Path tempPath = null;
        try {
            MimeType mimeType = getMimeType(file);

            if (!isImageFile(mimeType)) {
                throw new RuntimeException("Check image type.");
            }

            String encryptedFileName = HashUtil.sha256(file.getOriginalFilename() + salt + ZonedDateTime.now()).replaceAll("/", "_");
            Path path = Paths.get(filePath, encryptedFileName + "." + mimeType.getSubtype()); // 파일 저장 경로
            tempPath = path;
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING); // 파일 저장

            return savePhoto(path, file); // DB에 저장
        } catch (Exception e) {
            if (tempPath != null) {
                deleteFile(tempPath);
            }

            log.error("[FileService] fail to save file.", e);
            throw new RuntimeException(e);
        }
    }

    private String savePhoto(Path path, MultipartFile file) {
        Photo photo = Photo.builder()
                .encodedName(path.getFileName().toString())
                .originalName(file.getOriginalFilename())
                .path(path.toString())
                .fileExtension(getMimeType(file).getSubtype())
                .build();

        photoWriter.create(photo);

        return baseUrl + "/" + photo.getEncodedName();
    }

    private void deleteFile(Path path) {
        try {
            Files.delete(path);
        } catch (Exception e) {
            log.error("[FileService] fail to delete file.", e);
        }
    }

    private MimeType getMimeType(MultipartFile file) {
        return MimeTypeUtils.parseMimeType(Objects.requireNonNull(file.getContentType()));
    }

    private boolean isImageFile(MimeType mimeType) {
        return mimeType.getType().equals("image");
    }

}
