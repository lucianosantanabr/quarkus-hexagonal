package com.tech.application.exception.impl;

import com.tech.application.exception.BusinessException;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;

@Getter
@RegisterForReflection
public class BookNotFoundException extends BusinessException {

  public static final String CODE = "exception.book.notFound";
  public static final Integer STATUS = 412;
  public static final String MESSAGE = "Book with id=[bookId] was not found";

  public BookNotFoundException(Integer bookId) {
    super(STATUS, MESSAGE, CODE);
    param("bookId", bookId);
  }
}
