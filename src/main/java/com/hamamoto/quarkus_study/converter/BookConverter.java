package com.hamamoto.quarkus_study.converter;

import com.hamamoto.quarkus_study.entity.AuthorEntity;
import com.hamamoto.quarkus_study.entity.BookEntity;
import com.hamamoto.quarkus_study.entity.GenreEntity;
import com.hamamoto.quarkus_study.view.input.BookCreationInput;
import com.hamamoto.quarkus_study.view.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookConverter {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "isbn", target = "isbn")
    BookResponse toResponse(BookEntity bookEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "input.title", target = "title")
    @Mapping(source = "input.isbn", target = "isbn")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "author", target = "author")
    BookEntity toEntity(BookCreationInput input, GenreEntity genre, AuthorEntity author);
}
