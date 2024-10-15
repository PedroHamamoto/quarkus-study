package com.hamamoto.quarkus_study.service;

import com.hamamoto.quarkus_study.entity.Author;
import com.hamamoto.quarkus_study.repository.AuthorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public Author save(Author author) {
        authorRepository.persist(author);
        return author;
    }
}
