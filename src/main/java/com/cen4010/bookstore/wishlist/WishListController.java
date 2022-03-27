package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.book.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.naming.LimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "wishlist")
public class WishListController {

  private final WishListService wishListService;

  @Autowired
  public WishListController(WishListService wishListService) {
    this.wishListService = wishListService;
  }

  /**
   * List the books in a user's wishlist
   */
  @GetMapping("get")
  public WishList getWishList(@RequestParam UUID wishListId) {
    return wishListService.getWishListById(wishListId);
  }

  /**
   * List the books in a user's wishlist
   */
  @GetMapping("get/list")
  public List<Book> getBooksInWishList(@RequestParam UUID wishListId) {
    return new ArrayList<>(wishListService.getWishListById(wishListId).getBooks());
  }

  /**
   * Create a wishlist of books that belongs to user and has a unique name
   */
  @PostMapping("create")
  public WishList create(
      @RequestParam String name,
      @RequestParam UUID userid
  ) throws LimitExceededException {
    return wishListService.create(name, userid);
  }

  /**
   * add a book to a user’s wishlist
   */
  @PostMapping("add")
  public HttpStatus add(
      @RequestParam UUID bookId,
      @RequestParam UUID wishListId
  ) {
    wishListService.add(bookId, wishListId);
    return HttpStatus.OK;
  }

}