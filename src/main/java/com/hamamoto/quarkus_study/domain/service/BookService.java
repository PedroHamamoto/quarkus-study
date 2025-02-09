package com.hamamoto.quarkus_study.domain.service;

import com.hamamoto.quarkus_study.domain.Book;
import com.hamamoto.quarkus_study.infrastructure.converter.BookConverter;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.repository.AuthorPanacheRepository;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.repository.BookRepository;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.repository.GenreRepository;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.BookCreationInput;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorPanacheRepository authorPanacheRepository;
    private final GenreRepository genreRepository;
    private final BookConverter bookConverter;

    @Transactional
    public Book save(BookCreationInput bookCreationInput) {
        var genreEntity = genreRepository.findById(bookCreationInput.genreId());
        var authorEntity = authorPanacheRepository.findById(bookCreationInput.authorId());

        var bookEntity = bookConverter.toEntity(bookCreationInput, genreEntity, authorEntity);

        bookRepository.persist(bookEntity);

        return bookConverter.toDomain(bookEntity);
    }

    public long countPublishedBooksByAuthorId(long authorId) {
        return bookRepository.countByAuthorId(authorId);
    }
}
