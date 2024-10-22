package com.hamamoto.quarkus_study.converter;

import com.hamamoto.quarkus_study.entity.GenreEntity;
import com.hamamoto.quarkus_study.view.input.GenreCreationInput;
import com.hamamoto.quarkus_study.view.response.GenreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GenreConverter {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    GenreResponse toResponse(GenreEntity genreEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "name", target = "name")
    GenreEntity toEntity(GenreCreationInput input);
}
