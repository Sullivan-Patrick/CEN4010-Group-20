package com.cen4010.bookstore;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cen4010.bookstore.book.Book;
import com.cen4010.bookstore.book.BookRepository;
import com.cen4010.bookstore.wishlist.WishList;
import com.cen4010.bookstore.wishlist.WishListRepository;
import com.cen4010.bookstore.wishlist.WishListService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import javax.naming.LimitExceededException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WishListServiceTest {
  private static final UUID A_WISHLIST_UUID = UUID.randomUUID();
  private static final UUID A_USER_UUID = UUID.randomUUID();
  private static final UUID A_BOOK_UUID = UUID.randomUUID();
  private static final String A_WISHLIST_NAME = "test123";
  private WishListService wishListService;

  @Mock
  private WishListRepository wishListRepository;

  @Mock
  private BookRepository bookRepository;

  @Mock
  private WishList wishList;

  @Mock
  private WishList wishList2;

  @Mock
  private Book book;

  @BeforeEach
  public void setup() {
    wishListService = new WishListService(wishListRepository, bookRepository);
  }

  @Test
  public void itCreatesWishList() throws LimitExceededException {
    when(wishListRepository.findAll()).thenReturn(List.of());
    when(wishList.getUserId()).thenReturn(A_USER_UUID);
    when(wishList.getName()).thenReturn(A_WISHLIST_NAME);
    when(wishListRepository.save(
        any(WishList.class)
    ))
        .thenReturn(wishList);

    WishList result = wishListService.create(A_WISHLIST_NAME, A_USER_UUID);

    assertEquals(result.getUserId(), A_USER_UUID);
    assertEquals(result.getName(), A_WISHLIST_NAME);
    assertTrue(() -> result.getBooks().isEmpty());
  }

  @Test
  public void itGetsWishListById() {
    when(wishListRepository.findById(A_WISHLIST_UUID)).thenReturn(Optional.of(wishList));
    WishList result = wishListService.getWishListById(A_WISHLIST_UUID);

    assertEquals(result, wishList);
  }

  @Test
  public void itGetsWishListsForUser() {
    when(wishListRepository.findAll()).thenReturn(List.of(wishList, wishList2));
    when(wishList.getUserId()).thenReturn(A_USER_UUID);
    when(wishList2.getUserId()).thenReturn(A_USER_UUID);
    List<WishList> result = wishListService.getUserWishLists(A_USER_UUID);

    assertEquals(result, List.of(wishList, wishList2));
  }

  @Test
  public void itAddsWishList() {
    when(bookRepository.getById(A_BOOK_UUID)).thenReturn(book);
    when(wishListRepository.getById(A_WISHLIST_UUID)).thenReturn(wishList);
    when(wishListRepository.save(wishList)).thenReturn(wishList);
    wishListService.add(A_BOOK_UUID, A_WISHLIST_UUID);

    verify(wishList).addBook(book);
    verify(wishListRepository).save(wishList);
  }

  @Test
  public void itAddsToShoppingCartFromWishList() {
    when(bookRepository.getById(A_BOOK_UUID)).thenReturn(book);
    when(wishListRepository.getById(A_WISHLIST_UUID)).thenReturn(wishList);
    when(wishList.getBooks()).thenReturn(Set.of(book));

    wishListService.toCart(A_BOOK_UUID, A_WISHLIST_UUID);

    verify(wishList).removeBook(book);
    verify(wishListRepository).save(wishList);
  }

}
