package com.hamamoto.quarkus_study.presentation.graphql.dto.input;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.NonNull;

@Description("Author creation input")
public record AuthorCreationInput(@Description("Name") @NonNull String name) {}
