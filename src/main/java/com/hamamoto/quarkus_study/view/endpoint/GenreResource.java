package com.hamamoto.quarkus_study.view.endpoint;

import com.hamamoto.quarkus_study.converter.GenreConverter;
import com.hamamoto.quarkus_study.service.GenreService;
import com.hamamoto.quarkus_study.view.input.GenreCreationInput;
import com.hamamoto.quarkus_study.view.response.BookResponse;
import com.hamamoto.quarkus_study.view.response.GenreResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.eclipse.microprofile.graphql.*;

@GraphQLApi
@RequiredArgsConstructor
@Log
public class GenreResource {
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
