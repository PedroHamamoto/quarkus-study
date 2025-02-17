package com.hamamoto.quarkus_study.infrastructure.converter;

import com.hamamoto.quarkus_study.domain.Author;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.AuthorEntity;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorConverter {

  AuthorResponse toResponse(Author author);

  com.hamamoto.quarkus_study.proto.Author toProto(Author author);

  Author toDomain(AuthorEntity entity);

  AuthorEntity toEntity(Author author);
}
