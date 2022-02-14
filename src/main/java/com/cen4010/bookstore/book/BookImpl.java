package com.cen4010.bookstore.book;

public class BookImpl implements BookIF {

  private final String ISBN;
  private final String name;
  private final String description;
  private final double price;
  private final String author;
  private final String genre;
  private final String publisher;
  private final int yearPublished;
  private final int copiesSold;
    /*private final double rating;
    private final int id;*/

  public BookImpl(String ISBN, String name, String description, double price, String author,
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

  @Override
  public String getISBN() {
    return ISBN;
  }

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
