package com.cen4010.bookstore;


import static org.hamcrest.MatcherAssert.assertThat;

import com.cen4010.bookstore.wishlist.dao.WishListDaoIF;
import com.cen4010.bookstore.wishlist.WishListService;
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
    WishListDaoIF wishListDaoIF = wishListService.getWishListById();
    //todo: mock return from repository/persistence layer
  }

}
