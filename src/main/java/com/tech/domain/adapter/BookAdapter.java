package com.tech.domain.adapter;

import com.tech.application.exception.impl.BookNotFoundException;
import com.tech.domain.entity.Book;
import java.util.List;

public interface BookAdapter {

  List<Book> getAll();
  Book getId(Integer id) throws BookNotFoundException;

}
