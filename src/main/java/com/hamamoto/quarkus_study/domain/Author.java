package com.hamamoto.quarkus_study.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Author {
  private Long id;
  private String name;
}
