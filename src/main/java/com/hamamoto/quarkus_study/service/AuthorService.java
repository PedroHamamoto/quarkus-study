package com.hamamoto.quarkus_study.service;

import com.hamamoto.quarkus_study.entity.AuthorEntity;
import com.hamamoto.quarkus_study.repository.AuthorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public AuthorEntity save(AuthorEntity authorEntity) {
        authorRepository.persist(authorEntity);
        return authorEntity;
    }
}
