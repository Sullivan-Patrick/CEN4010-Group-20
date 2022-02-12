package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.wishlist.dao.WishListDaoIF;
import com.google.common.base.Objects;
import java.awt.print.Book;
import java.util.List;

/**
 * Wishlist with its appropriate books added
 */
public class HydratedWishListImpl implements HydratedWishListIF {

  private final List<Book> books;
  private final WishListDaoIF wishListDaoIF;

  public HydratedWishListImpl(List<Book> books,
      WishListDaoIF wishListDaoIF) {
    this.books = books;
    this.wishListDaoIF = wishListDaoIF;
  }

  @Override
  public List<Book> getBooks() {
    return books;
  }

  @Override
  public WishListDaoIF getWishListDaoIF() {
    return wishListDaoIF;
  }

  @Override
  public String toString() {
    return "HydratedWishListImpl{" +
        "books=" + books +
        ", wishListDaoIF=" + wishListDaoIF +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HydratedWishListImpl that = (HydratedWishListImpl) o;
    return Objects.equal(books, that.books)
        && Objects.equal(wishListDaoIF, that.wishListDaoIF);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(books, wishListDaoIF);
  }
}
