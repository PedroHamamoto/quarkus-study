package com.hamamoto.quarkus_study.infrastructure.converter;

import com.hamamoto.quarkus_study.domain.Book;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.AuthorEntity;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.BookEntity;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.GenreEntity;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.BookCreationInput;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookConverter {
    BookResponse toResponse(Book book);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "input.title", target = "title")
    @Mapping(source = "input.isbn", target = "isbn")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "author", target = "author")
    BookEntity toEntity(BookCreationInput input, GenreEntity genre, AuthorEntity author);

    Book toDomain(BookEntity entity);
}
