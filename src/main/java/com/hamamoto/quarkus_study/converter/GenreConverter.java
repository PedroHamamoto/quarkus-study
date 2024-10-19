package com.hamamoto.quarkus_study.converter;

import com.hamamoto.quarkus_study.entity.GenreEntity;
import com.hamamoto.quarkus_study.view.GenreDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GenreConverter {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    GenreDto toDto(GenreEntity genreEntity);
}
