package com.tech.domain.repository;

import com.tech.application.exception.impl.BookNotFoundException;
import com.tech.domain.entity.Book;
import java.util.List;

public interface BookRepository {

  List<Book> findAll();

  Book findByOptional(Integer id) throws BookNotFoundException;

  Book findById(Integer id) throws BookNotFoundException;
}
