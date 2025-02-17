package com.hamamoto.quarkus_study.infrastructure.converter;

import com.hamamoto.quarkus_study.domain.Author;
import com.hamamoto.quarkus_study.domain.Book;
import com.hamamoto.quarkus_study.domain.Genre;
import com.hamamoto.quarkus_study.domain.service.BookService;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.BookEntity;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.BookCreationInput;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.BookResponse;
import com.hamamoto.quarkus_study.proto.AddBookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    uses = {AuthorConverter.class, GenreConverter.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookConverter {
  BookResponse toResponse(Book book);

  @Mapping(target = "id", ignore = true)
  @Mapping(source = "command.title", target = "title")
  @Mapping(source = "command.isbn", target = "isbn")
  @Mapping(source = "genre", target = "genre")
  @Mapping(source = "author", target = "author")
  Book toDomain(BookService.BookCreationCommand command, Genre genre, Author author);

  BookEntity toEntity(Book book);

  Book toDomain(BookEntity entity);

  BookService.BookCreationCommand toBookCreationCommand(BookCreationInput input);

  BookService.BookCreationCommand toBookCreationCommand(AddBookRequest request);

  com.hamamoto.quarkus_study.proto.Book toProto(Book book);
}
