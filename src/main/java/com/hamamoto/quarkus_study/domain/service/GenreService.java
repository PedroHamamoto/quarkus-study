package com.hamamoto.quarkus_study.domain.service;

import com.hamamoto.quarkus_study.domain.Genre;
import com.hamamoto.quarkus_study.infrastructure.converter.GenreConverter;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.repository.GenreRepository;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.GenreCreationInput;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreConverter genreConverter;

    @Transactional
    public Genre save(String name) {
        var genre = Genre.builder().name(name).build();
        return genreRepository.save(genre);
    }

    public Genre findById(long id) {
        return genreRepository.findById(id);
    }

    public Genre findByBookId(long bookId) {
        return genreRepository.findByBookId(bookId);
    }
}
