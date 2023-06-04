package com.example.admin.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
@ActiveProfiles("dev")
class PhotoLocalServiceTest {
    @Autowired
    private PhotoService photoService;

    @Test
    void saveImageTest() throws IOException {
        //Given
        final String fileName = "ironman.png"; //파일명
        final String contentType = "image/png"; //파일타입
        final String filePath = "src/test/resources/images/" + fileName; //파일경로

        System.out.println(new File(filePath).exists());

        FileInputStream fileInputStream = new FileInputStream(filePath);

        //Mock파일생성
        MockMultipartFile image = new MockMultipartFile(
                "images", //name
                fileName, //originalFilename
                contentType,
                fileInputStream
        );

        //When & Then
        String photoUrl = photoService.uploadPhoto(image);
        System.out.println("photoUrl = " + photoUrl);
        Assertions.assertThat(photoUrl).contains("png");
    }

}
