package com.cen4010.bookstore;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.cen4010.bookstore.wishlist.WishListIF;
import com.cen4010.bookstore.wishlist.WishListImpl;
import com.cen4010.bookstore.wishlist.WishListService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WishListServiceTest {

  private WishListService wishListService;

  @BeforeEach
  public void setup() {
    wishListService = new WishListService();
  }

  @Test
  public void itReturnsExpectedWishList() {
    WishListIF wishListIF = wishListService.getWishList();
    //todo: mock return from repository/persistence layer
  }

}
