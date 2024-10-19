package com.hamamoto.quarkus_study.repository;

import com.hamamoto.quarkus_study.entity.AuthorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<AuthorEntity> {
}
