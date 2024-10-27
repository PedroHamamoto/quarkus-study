package com.hamamoto.quarkus_study.view.endpoint;

import com.hamamoto.quarkus_study.converter.AuthorConverter;
import com.hamamoto.quarkus_study.service.AuthorService;
import com.hamamoto.quarkus_study.view.input.AuthorCreationInput;
import com.hamamoto.quarkus_study.view.response.AuthorResponse;
import com.hamamoto.quarkus_study.view.response.BookResponse;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.*;

@GraphQLApi
@RequiredArgsConstructor
public class AuthorResource {

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
