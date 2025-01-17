package com.hamamoto.quarkus_study.presentation.graphql.dto.input;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.NonNull;

@Description("Genre creation input")
public record GenreCreationInput(
        @Description("Name") @NonNull String name
) {
}
