package com.hamamoto.quarkus_study.presentation.graphql.resolver;

import com.hamamoto.quarkus_study.domain.service.AuthorService;
import com.hamamoto.quarkus_study.infrastructure.converter.AuthorConverter;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.AuthorCreationInput;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.AuthorResponse;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.*;

@GraphQLApi
@RequiredArgsConstructor
public class AuthorResolver {

    private final AuthorService authorService;
    private final AuthorConverter authorConverter;

    @Mutation
    public AuthorResponse addAuthor(AuthorCreationInput input) {
        return authorConverter.toResponse(authorService.save(input));
    }

    @Query
    public AuthorResponse getAuthorById(@NonNull long id) {
        return authorConverter.toResponse(authorService.findById(id));
    }

    public AuthorResponse getAuthor(@Source BookResponse bookResponse) {
        return authorConverter.toResponse(authorService.findByBookId(bookResponse.id()));
    }

}
