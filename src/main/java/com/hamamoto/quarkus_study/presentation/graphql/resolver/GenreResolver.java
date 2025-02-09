package com.hamamoto.quarkus_study.presentation.graphql.resolver;

import com.hamamoto.quarkus_study.domain.service.GenreService;
import com.hamamoto.quarkus_study.infrastructure.converter.GenreConverter;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.GenreCreationInput;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.BookResponse;
import com.hamamoto.quarkus_study.presentation.graphql.dto.response.GenreResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.eclipse.microprofile.graphql.*;

@GraphQLApi
@RequiredArgsConstructor
@Log
public class GenreResolver {
    private final GenreService genreService;
    private final GenreConverter genreConverter;

    @Mutation
    public GenreResponse addGenre(GenreCreationInput input) {
        return genreConverter.toResponse(genreService.save(input));
    }

    @Query
    public GenreResponse getGenreById(@NonNull long id) {
        return genreConverter.toResponse(genreService.findById(id));
    }

    public GenreResponse getGenre(@Source BookResponse bookResponse) {
        return genreConverter.toResponse(genreService.findByBookId(bookResponse.id()));
    }
}
