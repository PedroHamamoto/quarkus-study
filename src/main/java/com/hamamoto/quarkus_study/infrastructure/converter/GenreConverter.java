package com.hamamoto.quarkus_study.infrastructure.converter;

import com.hamamoto.quarkus_study.domain.Genre;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.GenreEntity;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.GenreCreationInput;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.GenreResponse;
import org.mapstruct.Mapper;

@Mapper
public interface GenreConverter {

    GenreResponse toResponse(Genre genre);

    GenreEntity toEntity(GenreCreationInput input);

    Genre toDomain(GenreEntity entity);
}
