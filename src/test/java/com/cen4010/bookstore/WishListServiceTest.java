package com.cen4010.bookstore;


import static org.hamcrest.MatcherAssert.assertThat;

import com.cen4010.bookstore.book.BookRepository;
import com.cen4010.bookstore.wishlist.WishList;
import com.cen4010.bookstore.wishlist.WishListRepository;
import com.cen4010.bookstore.wishlist.WishListService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WishListServiceTest {
  private final UUID A_WISHLIST_UUID = UUID.randomUUID();
  private final UUID A_USER_UUID = UUID.randomUUID();
  private WishListService wishListService;

  @Mock
  private WishListRepository wishListRepository;

  @Mock
  private BookRepository bookRepository;

  @BeforeEach
  public void setup() {
    wishListService = new WishListService(wishListRepository, bookRepository);
  }

  @Test
  public void itReturnsExpectedWishList() {
    //todo: this test
  }

}
