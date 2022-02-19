package com.cen4010.bookstore.book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getBook(){
    return bookRepository.findAll();
  }

  public List<Book> findByGenre(String genre){
    return bookRepository.findBookByGenre(genre);
  }
}