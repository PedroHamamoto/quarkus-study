package com.hamamoto.quarkus_study.presentation.grpc;

import com.hamamoto.quarkus_study.domain.service.BookService;
import com.hamamoto.quarkus_study.infrastructure.converter.BookConverter;
import com.hamamoto.quarkus_study.proto.AddBookRequest;
import com.hamamoto.quarkus_study.proto.Book;
import com.hamamoto.quarkus_study.proto.BookApi;
import com.hamamoto.quarkus_study.proto.FindBookRequest;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@GrpcService
@RequiredArgsConstructor
public class BookGrpcServer implements BookApi {

  private final BookService bookService;
  private final BookConverter bookConverter;

  @Override
  @RunOnVirtualThread
  public Uni<Book> addBook(AddBookRequest request) {
    return Uni.createFrom()
        .item(bookService.save(bookConverter.toBookCreationCommand(request)))
        .map(bookConverter::toProto);
  }

  @Override
  @RunOnVirtualThread
  public Uni<Book> findBook(FindBookRequest request) {
    return Uni.createFrom().item(bookService.findById(request.getId())).map(bookConverter::toProto);
  }
}
