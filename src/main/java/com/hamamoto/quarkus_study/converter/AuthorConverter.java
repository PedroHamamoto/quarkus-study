package com.hamamoto.quarkus_study.converter;

import com.hamamoto.quarkus_study.entity.AuthorEntity;
import com.hamamoto.quarkus_study.view.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi",
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthorConverter {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    AuthorDto toDto(AuthorEntity authorEntity);
}
