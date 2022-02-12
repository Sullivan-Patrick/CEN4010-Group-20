package com.cen4010.bookstore.wishlist.dao;

import java.util.UUID;

/**
 * This class represents the relation table of the many-to-many relationship book:wishlist
 */
public class InWishListDao {

  private final UUID id;
  private final UUID bookId;
  private final UUID wishListId;

  public InWishListDao(UUID id, UUID bookId, UUID wishListId) {
    this.id = id;
    this.bookId = bookId;
    this.wishListId = wishListId;
  }

  public UUID getId() {
    return id;
  }

  @Override
  public String toString() {
    return "InWishListDao{" +
        "id=" + id +
        ", bookId=" + bookId +
        ", wishListId=" + wishListId +
        '}';
  }

  public UUID getBookId() {
    return bookId;
  }

  public UUID getWishListId() {
    return wishListId;
  }
}
