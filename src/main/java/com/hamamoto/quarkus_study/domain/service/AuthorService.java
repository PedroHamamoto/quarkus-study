package com.hamamoto.quarkus_study.domain.service;

import com.hamamoto.quarkus_study.domain.Author;
import com.hamamoto.quarkus_study.infrastructure.converter.AuthorConverter;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.repository.AuthorRepository;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.AuthorCreationInput;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Transactional
    public Author save(AuthorCreationInput input) {
        var authorEntity = authorConverter.toEntity(input);
        authorRepository.persist(authorEntity);
        return authorConverter.toDomain(authorEntity);
    }

    public Author findById(long id) {
        return authorConverter.toDomain(authorRepository.findById(id));
    }

    public Author findByBookId(long id) {
        return authorConverter.toDomain(authorRepository.findByBookId(id));
    }
}
