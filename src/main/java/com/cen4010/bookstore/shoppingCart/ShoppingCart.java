//package com.cen4010.bookstore.shoppingCart;
//
//import com.cen4010.bookstore.book.Book;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.UUID;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import org.hibernate.annotations.Type;
//
//@Entity
//@Table
//public class ShoppingCart {
//
//  @Id
//  @Column(name = "id")
//  @Type(type = "uuid-char")
//  private UUID userId;
//
//  public ShoppingCart(UUID userId) {
//    this.userId = userId;
//  }
//
//
//
//  public void addBook(Book book) {
//    booksInCart.add(book);
//  }
//
//  public void removeBook(Book book) {
//    booksInCart.remove(book);
//  }
//
//  public UUID getUserId() {
//    return userId;
//  }
//
//  public Set<Book> getBooksInCart() {
//    return booksInCart;
//  }
//}
