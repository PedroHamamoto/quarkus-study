package com.hamamoto.quarkus_study.view.response;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Type;

@Description("Represents a genre")
@Type("Genre")
public record GenreResponse(
        @Description("ID") @NonNull @Id String id,
        @Description("Name") @NonNull String name
) {}
