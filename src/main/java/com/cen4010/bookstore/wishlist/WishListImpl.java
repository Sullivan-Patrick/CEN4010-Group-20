package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.book.BookIF;
import com.google.common.base.Objects;
import java.util.List;
import java.util.UUID;

public class WishListImpl implements WishListIF {

  private final UUID id;
  private final UUID userId;
  private final String name;
  private final List<BookIF> books;

  public WishListImpl(UUID id, UUID userId, String name, List<BookIF> books) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.books = books;
  }

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public UUID getUserId() {
    return userId;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<BookIF> getBooks() {
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
    WishListImpl wishList = (WishListImpl) o;
    return Objects.equal(id, wishList.id)
        && Objects.equal(userId, wishList.userId)
        && Objects.equal(name, wishList.name)
        && Objects.equal(books, wishList.books);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, userId, name, books);
  }

  @Override
  public String toString() {
    return "WishListImpl{" +
        "id=" + id +
        ", userId=" + userId +
        ", name='" + name + '\'' +
        ", books=" + books +
        '}';
  }
}
