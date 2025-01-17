package com.hamamoto.quarkus_study.infrastructure.converter;

import com.hamamoto.quarkus_study.domain.Author;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.AuthorEntity;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.AuthorCreationInput;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorConverter {

    AuthorResponse toResponse(Author author);

    Author toDomain(AuthorEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "name", target = "name")
    AuthorEntity toEntity(AuthorCreationInput input);
}
