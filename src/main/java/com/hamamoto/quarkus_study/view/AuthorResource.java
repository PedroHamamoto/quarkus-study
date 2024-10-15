package com.hamamoto.quarkus_study.view;

import com.hamamoto.quarkus_study.entity.Author;
import com.hamamoto.quarkus_study.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

@GraphQLApi
@RequiredArgsConstructor
public class AuthorResource {

    private final AuthorService authorService;

    @Mutation
    public Author addAuthor(@Name("name") String name) {
        // TODO: refactor to use a proper DTO
        var author = new Author();
        author.setName(name);

        return authorService.save(author);
    }

}
