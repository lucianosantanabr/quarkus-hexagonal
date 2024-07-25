package com.tech.domain.service;

import com.tech.application.exception.impl.BookNotFoundException;
import com.tech.domain.entity.Book;
import com.tech.domain.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class BookUserCase implements BookRepository {

  private static final List<Book> books = Arrays
      .asList(Book.builder()
              .id(1)
              .name("Livro 1")
              .author("João")
              .build(),
          Book.builder()
              .id(2)
              .name("Livro 2")
              .author("José")
              .build(),
          Book.builder()
              .id(3)
              .name("Livro 3")
              .author("Maria")
              .build());


  @Override
  public List<Book> findAll() {
    return books;
  }

  @Override
  public Book findByOptional(Integer id) throws BookNotFoundException {
    return books.stream().filter(b -> b.getId().equals(id)).findFirst()
        .orElseThrow(() -> new BookNotFoundException(id));

  }

  @Override
  public Book findById(Integer id) throws BookNotFoundException {
    return findByOptional(id);
  }

}
