package com.hamamoto.quarkus_study.infrastructure.dataprovider.repository;

import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.GenreEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenreRepository implements PanacheRepository<GenreEntity> {

    public GenreEntity findByBookId(Long bookId) {
        return find(
                "select g from genres g join books b on b.genre.id = g.id where b.id = ?1",
                bookId
        ).firstResult();
    }
}
