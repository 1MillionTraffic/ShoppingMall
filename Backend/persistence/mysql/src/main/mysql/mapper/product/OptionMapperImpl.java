package com.example.mysql.mapper.product;

import com.example.domain.product.Option;
import com.example.mysql.entity.product.OptionEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T20:22:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.19 (Eclipse Adoptium)"
)
public class OptionMapperImpl implements OptionMapper {

    @Override
    public Option toDomain(OptionEntity optionEntity) {
        if ( optionEntity == null ) {
            return null;
        }

        Option.OptionBuilder option = Option.builder();

        option.optionId( optionEntity.getOptionId() );

        return option.build();
    }

    @Override
    public OptionEntity toEntity(Option option) {
        if ( option == null ) {
            return null;
        }

        OptionEntity.OptionEntityBuilder optionEntity = OptionEntity.builder();

        optionEntity.optionId( option.getOptionId() );

        return optionEntity.build();
    }
}
