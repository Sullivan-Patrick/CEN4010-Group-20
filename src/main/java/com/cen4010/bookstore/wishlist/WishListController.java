package com.cen4010.bookstore.wishlist;

import java.util.UUID;
import javax.naming.LimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping
  public WishList getWishList() {
    return null;
  }

  @PostMapping("create")
  public WishList create(
      @RequestParam String name,
      @RequestParam UUID userid
  ) throws LimitExceededException {
    return wishListService.create(name, userid);
  }

}