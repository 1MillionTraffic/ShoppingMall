package com.example.mysql.mapper.product;

import com.example.mysql.domain.product.Shop;
import com.example.mysql.entity.product.ShopEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class ShopMapperImpl implements ShopMapper {

    @Override
    public Shop toDomain(ShopEntity shopEntity) {
        if ( shopEntity == null ) {
            return null;
        }

        Shop.ShopBuilder shop = Shop.builder();

        shop.shopId( shopEntity.getShopId() );

        return shop.build();
    }

    @Override
    public ShopEntity toEntity(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopEntity.ShopEntityBuilder shopEntity = ShopEntity.builder();

        shopEntity.shopId( shop.getShopId() );

        return shopEntity.build();
    }
}
