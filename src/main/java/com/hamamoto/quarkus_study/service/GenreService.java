package com.hamamoto.quarkus_study.service;

import com.hamamoto.quarkus_study.entity.AuthorEntity;
import com.hamamoto.quarkus_study.entity.GenreEntity;
import com.hamamoto.quarkus_study.repository.AuthorRepository;
import com.hamamoto.quarkus_study.repository.GenreRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    @Transactional
    public GenreEntity save(GenreEntity genreEntity) {
        genreRepository.persist(genreEntity);
        return genreEntity;
    }
}
