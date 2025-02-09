package com.hamamoto.quarkus_study.infrastructure.dataprovider.repository;

import com.hamamoto.quarkus_study.domain.Genre;
import com.hamamoto.quarkus_study.infrastructure.converter.GenreConverter;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.GenreEntity;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class GenreRepository {
    private final GenreConverter genreConverter;
    private final GenrePanacheRepository genrePanacheRepository;

    public Genre findById(Long id) {
        return genreConverter.toDomain(genrePanacheRepository.findById(id));
    }

    public Genre findByBookId(Long bookId) {
        return genreConverter.toDomain(genrePanacheRepository.findByBookId(bookId));
    }

    public Genre save(Genre genre) {
        var genreEntity = genreConverter.toEntity(genre);
        genrePanacheRepository.persist(genreEntity);

        return genreConverter.toDomain(genreEntity);
    }
}
