package com.cen4010.bookstore.book;

<<<<<<< HEAD
=======
import com.cen4010.bookstore.wishlist.WishList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
>>>>>>> master
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
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
=======
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Book {

  @Id
  @Column(name = "id")
  @Type(type = "uuid-char")
  private UUID isbn;
  private String name;

  @ManyToMany(mappedBy = "books")
  private Set<WishList> wishListsWithBook = new HashSet<>();

  public UUID getIsbn() {
    return isbn;
  }

>>>>>>> master
  public String getName() {
    return name;
  }

<<<<<<< HEAD
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
=======
  public Set<WishList> getWishListsWithBook() {
    return wishListsWithBook;
>>>>>>> master
  }
}
