package com.hamamoto.quarkus_study.repository;

import com.hamamoto.quarkus_study.entity.BookEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository implements PanacheRepository<BookEntity> {

    public long countByAuthorId(long authorId) {
        return count("author.id", authorId);
    }
}
