package com.hamamoto.quarkus_study.converter;

import com.hamamoto.quarkus_study.entity.AuthorEntity;
import com.hamamoto.quarkus_study.view.input.AuthorCreationInput;
import com.hamamoto.quarkus_study.view.response.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorConverter {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    AuthorResponse toResponse(AuthorEntity authorEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "name", target = "name")
    AuthorEntity toEntity(AuthorCreationInput input);
}
