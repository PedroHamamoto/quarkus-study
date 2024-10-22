package com.hamamoto.quarkus_study.view.endpoint;

import com.hamamoto.quarkus_study.converter.GenreConverter;
import com.hamamoto.quarkus_study.service.GenreService;
import com.hamamoto.quarkus_study.view.input.GenreCreationInput;
import com.hamamoto.quarkus_study.view.response.GenreResponse;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
@RequiredArgsConstructor
public class GenreResource {
    private final GenreService genreService;
    private final GenreConverter genreConverter;

    @Mutation
    public GenreResponse addGenre(GenreCreationInput input) {
        return genreConverter.toResponse(genreService.save(input));
    }

    @Query
    public GenreResponse getGenreById(@NonNull Long id) {
        return genreConverter.toResponse(genreService.findById(id));
    }
}
