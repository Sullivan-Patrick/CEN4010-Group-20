package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.book.BookIF;
import java.util.List;
import java.util.UUID;

public interface WishListIF {

  UUID getId();

  UUID getUserId();

  String getName();

  List<BookIF> getBooks();
}
