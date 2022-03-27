package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.book.Book;
import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table
public class WishList {

  @Id
  @Column(name = "id")
  @Type(type = "uuid-char")
  private UUID id;
  private UUID userId;
  private String name;

  public WishList() {
  }

  public WishList(UUID id, UUID userId, String name) {
    this.id = id;
    this.userId = userId;
    this.name = name;
  }

  @ManyToMany
  @JoinTable(
      name = "in_wishlist",
      joinColumns = @JoinColumn(name = "wishlist_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id")
  )
  private Set<Book> books = new HashSet<>();

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public UUID getId() {
    return id;
  }

  public UUID getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public Set<Book> getBooks() {
    return books;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WishList wishList = (WishList) o;
    return Objects.equal(id, wishList.id)
        && Objects.equal(userId, wishList.userId)
        && Objects.equal(name, wishList.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, userId, name);
  }

  @Override
  public String toString() {
    return "WishListImpl{" +
        "id=" + id +
        ", userId=" + userId +
        ", name='" + name + '\'' +
        '}';
  }
}
