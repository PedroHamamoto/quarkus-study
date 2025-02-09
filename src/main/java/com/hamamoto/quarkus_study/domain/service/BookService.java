package com.hamamoto.quarkus_study.domain.service;

import com.hamamoto.quarkus_study.domain.Book;
import com.hamamoto.quarkus_study.infrastructure.converter.BookConverter;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.repository.BookRepository;
import com.hamamoto.quarkus_study.presentation.graphql.dto.input.BookCreationInput;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookConverter bookConverter;

    @Transactional
    public Book save(BookCreationInput bookCreationInput) {
        var genre = genreService.findById(bookCreationInput.genreId());
        var author = authorService.findById(bookCreationInput.authorId());
        var book = bookConverter.toDomain(bookCreationInput, genre, author);

        return bookRepository.save(book);
    }

    public long countPublishedBooksByAuthorId(long authorId) {
        return bookRepository.countByAuthorId(authorId);
    }

    public Book findById(long id) {
        return bookRepository.findById(id);
    }
}
