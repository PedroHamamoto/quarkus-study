package com.hamamoto.quarkus_study.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Book {
    private Long id;
    private String title;
    private String isbn;
}
