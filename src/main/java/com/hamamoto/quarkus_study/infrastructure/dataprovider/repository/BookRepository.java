package com.hamamoto.quarkus_study.infrastructure.dataprovider.repository;

import com.hamamoto.quarkus_study.domain.Book;
import com.hamamoto.quarkus_study.infrastructure.converter.BookConverter;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ApplicationScoped
public class BookRepository {
    private final BookPanacheRepository bookPanacheRepository;
    private final BookConverter bookConverter;

    public Book findById(long id) {
        return bookConverter.toDomain(bookPanacheRepository.findById(id));
    }

    public long countByAuthorId(long authorId) {
        return bookPanacheRepository.countByAuthorId(authorId);
    }

    public Book save(Book book) {
        var bookEntity = bookConverter.toEntity(book);
        bookPanacheRepository.persist(bookEntity);

        return bookConverter.toDomain(bookEntity);
    }
}
