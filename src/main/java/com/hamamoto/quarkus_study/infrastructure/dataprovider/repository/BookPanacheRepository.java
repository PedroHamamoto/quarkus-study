package com.hamamoto.quarkus_study.infrastructure.dataprovider.repository;

import com.hamamoto.quarkus_study.infrastructure.dataprovider.entity.BookEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookPanacheRepository implements PanacheRepository<BookEntity> {

    public long countByAuthorId(long authorId) {
        return count("author.id", authorId);
    }
}
