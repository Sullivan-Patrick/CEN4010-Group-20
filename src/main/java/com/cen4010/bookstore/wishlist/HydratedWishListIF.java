package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.wishlist.dao.WishListDaoIF;
import java.awt.print.Book;
import java.util.List;

public interface HydratedWishListIF {

  public List<Book> getBooks();

  public WishListDaoIF getWishListDaoIF();
}
