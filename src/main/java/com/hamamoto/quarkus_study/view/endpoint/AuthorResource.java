package com.hamamoto.quarkus_study.view.endpoint;

import com.hamamoto.quarkus_study.converter.AuthorConverter;
import com.hamamoto.quarkus_study.service.AuthorService;
import com.hamamoto.quarkus_study.view.input.AuthorCreationInput;
import com.hamamoto.quarkus_study.view.response.AuthorResponse;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

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
    public AuthorResponse getAuthorById(@NonNull Long id) {
        return authorConverter.toResponse(authorService.findById(id));
    }

}
