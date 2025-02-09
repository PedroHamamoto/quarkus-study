package com.hamamoto.quarkus_study.presentation.graphql.resolver;

import com.hamamoto.quarkus_study.domain.service.BookService;
import com.hamamoto.quarkus_study.infrastructure.converter.BookConverter;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.BookCreationInput;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.AuthorResponse;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
@RequiredArgsConstructor
public class BookResolver {
    private final BookService bookService;
    private final BookConverter bookConverter;

    @Mutation
    public BookResponse addBook(BookCreationInput input) {
        return bookConverter.toResponse(bookService.save(input));
    }

    public long getPublishedBooksCount(@Source AuthorResponse authorResponse) {
        return bookService.countPublishedBooksByAuthorId(authorResponse.id());
    }
}
