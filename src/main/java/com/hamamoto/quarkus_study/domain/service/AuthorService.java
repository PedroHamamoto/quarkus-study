package com.hamamoto.quarkus_study.domain.service;

import com.hamamoto.quarkus_study.domain.Author;
import com.hamamoto.quarkus_study.infrastructure.dataprovider.repository.AuthorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class AuthorService {
  private final AuthorRepository authorRepository;

  @Transactional
  public Author save(String name) {
    var author = Author.builder().name(name).build();
    return authorRepository.save(author);
  }

  public Author findById(long id) {
    return authorRepository.findById(id);
  }

  public Author findByBookId(long bookId) {
    return authorRepository.findByBookId(bookId);
  }
}
