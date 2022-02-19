package com.cen4010.bookstore.book;

public interface BookIF {

  Long getId();

  String getISBN();

  String getName();

  String getDescription();

  double getPrice();

  String getAuthor();

  String getGenre();

  String getPublisher();

  int getYearPublished();

  int getCopiesSold();

}
