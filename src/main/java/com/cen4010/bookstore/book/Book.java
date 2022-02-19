package com.cen4010.bookstore.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Book implements BookIF {

  @Id
  @SequenceGenerator(
      name = "book_sequence",
      sequenceName = "book_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "book_sequence"
  )
  private Long id;
  private String ISBN;
  private String name;
  private String description;
  private double price;
  private String author;
  private String genre;
  private String publisher;
  private int yearPublished;
  private int copiesSold;
    /*private final double rating;
    private final int id;*/

  public Book(Long id, String ISBN, String name, String description, double price,
      String author,
      String genre, String publisher, int yearPublished, int copiesSold) {
    this.id = id;
    this.ISBN = ISBN;
    this.name = name;
    this.description = description;
    this.price = price;
    this.author = author;
    this.genre = genre;
    this.publisher = publisher;
    this.yearPublished = yearPublished;
    this.copiesSold = copiesSold;
  }

  public Book(String ISBN, String name, String description, double price, String author,
      String genre, String publisher, int yearPublished, int copiesSold) {
    this.ISBN = ISBN;
    this.name = name;
    this.description = description;
    this.price = price;
    this.author = author;
    this.genre = genre;
    this.publisher = publisher;
    this.yearPublished = yearPublished;
    this.copiesSold = copiesSold;
  }

  public Book() {
  }

  @Override
  public String getISBN() {
    return ISBN;
  }

  @Override
  public Long getId(){return id;}

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public String getAuthor() {
    return author;
  }

  @Override
  public String getGenre() {
    return genre;
  }

  @Override
  public String getPublisher() {
    return publisher;
  }

  @Override
  public int getYearPublished() {
    return yearPublished;
  }

  @Override
  public int getCopiesSold() {
    return copiesSold;
  }
}
