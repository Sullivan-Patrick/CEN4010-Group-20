package com.cen4010.bookstore.book;

import com.cen4010.bookstore.wishlist.WishList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;


@Entity
@Table
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
  //private final double rating;

  @JsonIgnore
  @ManyToMany(mappedBy = "books")
  private Set<WishList> wishListsWithBook = new HashSet<>();

  public Book(){

  }

   public Book(UUID id, String ISBN, String name, String description, double price,
      String author, String genre, String publisher, int yearPublished, int copiesSold, Set<WishList> wishListsWithBook) {
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
    this.wishListsWithBook = wishListsWithBook;
  }

   public Book(UUID id, String ISBN, String name, String description, double price,
      String author, String genre, String publisher, int yearPublished, int copiesSold) {
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


  public UUID getId() {
    return id;
  }

  public void setId(UUID id){
    this.id = id;
  }

  public String getIsbn() {
    return ISBN;
  }

  public void setIsbn(String ISBN){
    this.ISBN = ISBN;
  }

  public String getName() {
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price){
    this.price = price;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author){
    this.author = author;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre){
    this.genre = genre;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher){
    this.publisher = publisher;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  public void setYearPublished(int yearPublished){
    this.yearPublished = yearPublished;
  }

  public int getCopiesSold() {
    return copiesSold;
  }

  public void setCopiesSold(int copiesSold){
    this.copiesSold = copiesSold;
  }

  public Set<WishList> getWishListsWithBook() {
    return wishListsWithBook;
  }

  @Override
  public String toString() {
    return "Book{" +
        "The ISBN is=" + ISBN +
        ", Name='" + name + '\'' +
        ", wishListsWithBook=" + wishListsWithBook +
        '}';
  }

}
