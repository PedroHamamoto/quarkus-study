package com.hamamoto.quarkus_study.view;

import com.hamamoto.quarkus_study.converter.GenreConverter;
import com.hamamoto.quarkus_study.entity.GenreEntity;
import com.hamamoto.quarkus_study.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

@GraphQLApi
@RequiredArgsConstructor
public class GenreResource {
    private final GenreService genreService;
    private final GenreConverter genreConverter;

    @Mutation
    public GenreDto addGenre(@Name("name") String name) {
        var genreEntity = new GenreEntity();
        genreEntity.setName(name);

        return genreConverter.toDto(genreService.save(genreEntity));
    }
}
