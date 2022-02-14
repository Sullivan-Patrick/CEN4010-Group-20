package com.cen4010.bookstore.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

  public BookImpl getBook() {
    return new BookImpl(
        "10-7x",
        "Test book",
        "This is a test book",
        19.99,
        "Gino Surace",
        "Fantasy",
        "Group 20",
        2022,
        1
    );
  }
}
