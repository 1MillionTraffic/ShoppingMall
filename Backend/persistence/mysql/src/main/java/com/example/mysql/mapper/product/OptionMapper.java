package com.example.mysql.mapper.product;


import com.example.domain.product.Option;
import com.example.mysql.entity.product.OptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface OptionMapper {
    OptionMapper INSTANCE = Mappers.getMapper(OptionMapper.class);

    Option toDomain(OptionEntity optionEntity);

    OptionEntity toEntity(Option option);
}
