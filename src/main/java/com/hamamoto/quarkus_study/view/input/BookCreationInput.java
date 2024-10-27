package com.hamamoto.quarkus_study.view.input;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

@Description("Book creation input")
public record BookCreationInput(
        @Description("Title") @NonNull String title,
        @Description("ISBN") @NonNull String isbn,
        @Description("Genre ID") @NonNull @Id long genreId,
        @Description("Author ID") @NonNull @Id long authorId) {
}
