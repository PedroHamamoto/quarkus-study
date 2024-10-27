package com.hamamoto.quarkus_study.service;

import com.hamamoto.quarkus_study.converter.BookConverter;
import com.hamamoto.quarkus_study.entity.BookEntity;
import com.hamamoto.quarkus_study.repository.AuthorRepository;
import com.hamamoto.quarkus_study.repository.BookRepository;
import com.hamamoto.quarkus_study.repository.GenreRepository;
import com.hamamoto.quarkus_study.view.input.BookCreationInput;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookConverter bookConverter;

    @Transactional
    public BookEntity save(BookCreationInput bookCreationInput) {
        var genre = genreRepository.findById(bookCreationInput.genreId());
        var author = authorRepository.findById(bookCreationInput.authorId());

        var book = bookConverter.toEntity(bookCreationInput, genre, author);

        bookRepository.persist(book);

        return book;
    }

    public long countPublishedBooksByAuthorId(long authorId) {
        return bookRepository.countByAuthorId(authorId);
    }
}
