package com.example.mysql.mapper.photo;

import com.example.domain.photo.Photo;
import com.example.mysql.entity.photo.PhotoEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class PhotoMapperImpl implements PhotoMapper {

    @Override
    public Photo toDomain(PhotoEntity photoEntity) {
        if ( photoEntity == null ) {
            return null;
        }

        Photo.PhotoBuilder photo = Photo.builder();

        photo.photoId( photoEntity.getPhotoId() );

        return photo.build();
    }

    @Override
    public PhotoEntity toEntity(Photo photo) {
        if ( photo == null ) {
            return null;
        }

        PhotoEntity.PhotoEntityBuilder photoEntity = PhotoEntity.builder();

        photoEntity.photoId( photo.getPhotoId() );

        return photoEntity.build();
    }
}
