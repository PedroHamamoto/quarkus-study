package com.hamamoto.quarkus_study.infrastructure.dataprovider.repository;

import com.hamamoto.quarkus_study.domain.Author;
import com.hamamoto.quarkus_study.infrastructure.converter.AuthorConverter;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class AuthorRepository {

    private final AuthorPanacheRepository authorPanacheRepository;
    private final AuthorConverter authorConverter;

    public Author findById(Long id) {
        return authorConverter.toDomain(authorPanacheRepository.findById(id));
    }

    public Author findByBookId(Long bookId) {
        return authorConverter.toDomain(authorPanacheRepository.findByBookId(bookId));
    }

    public Author save(Author author) {
        var authorEntity = authorConverter.toEntity(author);
        authorPanacheRepository.persist(authorEntity);

        return authorConverter.toDomain(authorEntity);
    }

}
