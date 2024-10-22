package com.hamamoto.quarkus_study.view.endpoint;

import com.hamamoto.quarkus_study.converter.BookConverter;
import com.hamamoto.quarkus_study.service.BookService;
import com.hamamoto.quarkus_study.view.input.BookCreationInput;
import com.hamamoto.quarkus_study.view.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;

@GraphQLApi
@RequiredArgsConstructor
public class BookResource {
    private final BookService bookService;
    private final BookConverter bookConverter;

    @Mutation
    public BookResponse addBook(BookCreationInput input) {
        return bookConverter.toResponse(bookService.save(input));
    }
}
