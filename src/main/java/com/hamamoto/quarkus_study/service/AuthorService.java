package com.hamamoto.quarkus_study.service;

import com.hamamoto.quarkus_study.converter.AuthorConverter;
import com.hamamoto.quarkus_study.entity.AuthorEntity;
import com.hamamoto.quarkus_study.repository.AuthorRepository;
import com.hamamoto.quarkus_study.view.input.AuthorCreationInput;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Transactional
    public AuthorEntity save(AuthorCreationInput input) {
        var author = authorConverter.toEntity(input);
        authorRepository.persist(author);
        return author;
    }

    public AuthorEntity findById(long id) {
        return authorRepository.findById(id);
    }

    public AuthorEntity findByBookId(long id) {
        return authorRepository.findByBookId(id);
    }
}
