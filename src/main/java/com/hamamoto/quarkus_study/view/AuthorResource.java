package com.hamamoto.quarkus_study.view;

import com.hamamoto.quarkus_study.converter.AuthorConverter;
import com.hamamoto.quarkus_study.entity.AuthorEntity;
import com.hamamoto.quarkus_study.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

@GraphQLApi
@RequiredArgsConstructor
public class AuthorResource {

    private final AuthorService authorService;
    private final AuthorConverter authorConverter;

    @Mutation
    public AuthorDto addAuthor(@Name("name") String name) {
        var author = new AuthorEntity();
        author.setName(name);

        return authorConverter.toDto(authorService.save(author));
    }

}
