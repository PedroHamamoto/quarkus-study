package com.hamamoto.quarkus_study.infrastructure.dataprovider.repository;

import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.AuthorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<AuthorEntity> {
    public AuthorEntity findByBookId(long bookId) {
        return find(
                "select a from authors a join books b on b.author.id = a.id where b.id = ?1",
                bookId
        ).firstResult();
    }
}
