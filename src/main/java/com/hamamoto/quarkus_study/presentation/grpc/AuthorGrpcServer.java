package com.hamamoto.quarkus_study.presentation.grpc;

import com.hamamoto.quarkus_study.proto.AddAuthorRequest;
import com.hamamoto.quarkus_study.proto.Author;
import com.hamamoto.quarkus_study.proto.AuthorApi;
import com.hamamoto.quarkus_study.proto.FindAuthorRequest;
import com.hamamoto.quarkus_study.domain.service.AuthorService;
import com.hamamoto.quarkus_study.infrastructure.converter.AuthorConverter;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@GrpcService
@RequiredArgsConstructor
public class AuthorGrpcServer implements AuthorApi {
    private final AuthorService authorService;

    @Override
    @RunOnVirtualThread
    public Uni<Author> addAuthor(AddAuthorRequest request) {
        return Uni.createFrom()
                .item(authorService.save(request.getName()))
                .map(this::toAuthorResponse);
    }

    @Override
    @RunOnVirtualThread
    public Uni<Author> findAuthor(FindAuthorRequest request) {
        return Uni.createFrom()
                .item(authorService.findById(request.getId()))
                .map(this::toAuthorResponse);
    }

    private Author toAuthorResponse(com.hamamoto.quarkus_study.domain.Author author) {
        return Author.newBuilder()
                .setId(author.getId())
                .setName(author.getName())
                .build();
    }

}
