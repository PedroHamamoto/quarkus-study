package com.hamamoto.quarkus_study.service;

import com.hamamoto.quarkus_study.converter.GenreConverter;
import com.hamamoto.quarkus_study.entity.GenreEntity;
import com.hamamoto.quarkus_study.repository.GenreRepository;
import com.hamamoto.quarkus_study.view.input.GenreCreationInput;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreConverter genreConverter;

    @Transactional
    public GenreEntity save(GenreCreationInput input) {
        var genre = genreConverter.toEntity(input);
        genreRepository.persist(genre);

        return genre;
    }

    public GenreEntity findById(Long id) {
        return genreRepository.findById(id);
    }
}
