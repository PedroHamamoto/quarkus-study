package com.hamamoto.quarkus_study.infrastructure.converter;

import com.hamamoto.quarkus_study.domain.Genre;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.GenreEntity;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.GenreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenreConverter {

  GenreResponse toResponse(Genre genre);

  com.hamamoto.quarkus_study.proto.Genre toProto(Genre genre);

  GenreEntity toEntity(Genre genre);

  Genre toDomain(GenreEntity entity);
}
