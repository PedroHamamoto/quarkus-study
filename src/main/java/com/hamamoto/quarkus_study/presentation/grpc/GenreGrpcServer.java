package com.hamamoto.quarkus_study.presentation.grpc;

import com.hamamoto.quarkus_study.domain.service.GenreService;
import com.hamamoto.quarkus_study.infrastructure.converter.GenreConverter;
import com.hamamoto.quarkus_study.proto.AddGenreRequest;
import com.hamamoto.quarkus_study.proto.FindGenreRequest;
import com.hamamoto.quarkus_study.proto.Genre;
import com.hamamoto.quarkus_study.proto.GenreApi;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@GrpcService
@RequiredArgsConstructor
public class GenreGrpcServer implements GenreApi {
    private final GenreService genreService;

    @Override
    @RunOnVirtualThread
    public Uni<Genre> addGenre(AddGenreRequest request) {
        return Uni.createFrom().item(genreService.save(request.getName())).map(this::toGenreResponse);
    }

    @Override
    @RunOnVirtualThread
    public Uni<Genre> findGenre(FindGenreRequest request) {
        return Uni.createFrom().item(genreService.findById(request.getId())).map(this::toGenreResponse);
    }

    private Genre toGenreResponse(com.hamamoto.quarkus_study.domain.Genre genre) {
        return Genre.newBuilder().setName(genre.getName()).setId(genre.getId()).build();
    }

}
