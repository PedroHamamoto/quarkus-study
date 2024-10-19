package com.hamamoto.quarkus_study.repository;

import com.hamamoto.quarkus_study.entity.AuthorEntity;
import com.hamamoto.quarkus_study.entity.GenreEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenreRepository implements PanacheRepository<GenreEntity> {
}
