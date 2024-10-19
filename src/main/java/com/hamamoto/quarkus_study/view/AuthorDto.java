package com.hamamoto.quarkus_study.view;


import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Type;

@Description("Represents an author")
@Type("Author")
public record AuthorDto(
        @Description("ID") @NonNull @Id String id,
        @Description("Name") @NonNull String name) {
}
