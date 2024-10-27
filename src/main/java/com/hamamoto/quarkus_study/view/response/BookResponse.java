package com.hamamoto.quarkus_study.view.response;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Type;

@Description("Represents a book")
@Type("Book")
public record BookResponse(
        @Description("ID") @NonNull @Id long id,
        @Description("Title") @NonNull String title,
        @Description("ISBN") @NonNull String isbn) {
}
