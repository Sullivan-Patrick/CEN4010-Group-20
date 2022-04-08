package com.cen4010.bookstore.book;

import java.util.*;

//import org.hibernate.validator.constraints.ISBN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  public void addBook(Book book){
    Optional<Book> bookOptional = bookRepository.confirmBookByIsbn(book.getIsbn());
    if (bookOptional.isPresent()){
        throw new IllegalStateException("The book's ISBN already exists.");
      }
    bookRepository.save(book);
  }

  public List<Book> findByGenre(String genre){
    return bookRepository.findByGenre(genre);
  }

  public List<Book> findMostSold(){
    return bookRepository.findTop10ByOrderByCopiesSoldDesc();
  }

  public List<Book> findBooksByAuthor(String author){
    return bookRepository.findBooksByAuthor(author);
  }

  public List<Book> findBookByIsbn(String ISBN){
    return bookRepository.findBookByIsbn(ISBN);
  }


  public Page<Book> pageSearch(int page, int size){
    Pageable pageable = PageRequest.of(page, size);
    Page<Book> pageResults = bookRepository.findAll(pageable);
    return pageResults;
  }

  public List<Book> limitByRating(double rating){
    return bookRepository.findByRatingGreaterThanEqualOrderByRatingDesc(rating);
  }
}