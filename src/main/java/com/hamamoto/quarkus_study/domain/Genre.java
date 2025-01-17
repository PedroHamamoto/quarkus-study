package com.hamamoto.quarkus_study.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Genre {
    private Long id;
    private String name;
}
