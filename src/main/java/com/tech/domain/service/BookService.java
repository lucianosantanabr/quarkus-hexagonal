package com.tech.domain.service;

import com.tech.application.exception.impl.BookNotFoundException;
import com.tech.domain.adapter.BookAdapter;
import com.tech.domain.entity.Book;
import com.tech.domain.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookService implements BookAdapter {

  @Inject
  BookRepository bookRepo;

  @Override
  public List<Book> getAll() {
    return bookRepo.findAll();
  }

  @Override
  public Book getId(Integer id) throws BookNotFoundException {
    return bookRepo.findById(id);
  }
}
