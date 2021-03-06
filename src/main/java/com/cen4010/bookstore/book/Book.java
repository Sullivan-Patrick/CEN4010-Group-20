package com.cen4010.bookstore.book;

import com.cen4010.bookstore.profileManagement.entity.UserEntity;
import com.cen4010.bookstore.wishlist.WishList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.Type;


@Entity
public class Book {

  @Id
  @GeneratedValue
  @Column(name = "id")
  @Type(type = "uuid-char")
  private UUID id;
  private String ISBN;
  private String name;
  private String description;
  private double price;
  private String author;
  private String genre;
  private String publisher;
  private int yearPublished;
  private int copiesSold;
  private double rating;
  @JsonIgnore
  @ManyToMany(mappedBy = "books")
  private Set<WishList> wishListsWithBook = new HashSet<>();

  @ManyToMany(mappedBy = "booksInCart")
  private Set<UserEntity> bookInCart = new HashSet<>();


  public Book(UUID id, String ISBN, String name, String description, double price,
      String author, String genre, String publisher, int yearPublished, int copiesSold, double rating,
      Set<WishList> wishListsWithBook, Set<UserEntity> bookInCart) {
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
    this.rating = rating;
    this.wishListsWithBook = wishListsWithBook;
    this.bookInCart = bookInCart;
  }

  public Book(UUID id, String ISBN, String name, String description, double price,
      String author, String genre, String publisher, int yearPublished, int copiesSold, double rating) {
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
    this.rating = rating;
  }

  public Book() {
  }

  public UUID getId() {
    return id;
  }

  public String getIsbn() {
    return ISBN ;
  }

  public void setIsbn(String ISBN){
    this.ISBN = ISBN;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public String getAuthor() {
    return author;
  }

  public String getGenre() {
    return genre;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  public int getCopiesSold() {
    return copiesSold;
  }

  public double getRating() {
    return rating;
  }

  public Set<WishList> getWishListsWithBook() {
    return wishListsWithBook;
  }

  public Set<UserEntity> getBookInCart() {
    return bookInCart;
  }

  @Override
  public String toString() {
    return "Book{" +
        "The isbn is=" + ISBN +
        ", Name='" + name + '\'' +
        ", wishListsWithBook=" + wishListsWithBook +
        '}';
  }
}
