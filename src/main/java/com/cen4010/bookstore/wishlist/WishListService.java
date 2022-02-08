package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.book.BookIF;
import java.util.ArrayList;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class WishListService {

  public WishListIF getWishList() {
    return new WishListImpl(
        UUID.randomUUID(),
        UUID.randomUUID(),
        "Mr Jumpi",
        new ArrayList<BookIF>()
    );
  }
}
