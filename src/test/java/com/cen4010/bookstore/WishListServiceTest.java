package com.cen4010.bookstore;


import static org.hamcrest.MatcherAssert.assertThat;

import com.cen4010.bookstore.wishlist.WishList;
import com.cen4010.bookstore.wishlist.WishListService;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class WishListServiceTest {

  private WishListService wishListService;
//
//  @BeforeEach
//  public void setup() {
//    wishListService = new WishListService();
//  }

  @Test
  public void itReturnsExpectedWishList() {
    WishList WishList = wishListService.getWishListById(UUID.randomUUID());
    //todo: mock return from repository/persistence layer
  }

}
