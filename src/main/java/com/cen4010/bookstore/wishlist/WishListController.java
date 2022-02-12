package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.wishlist.dao.WishListDaoIF;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public WishListDaoIF getWishList() {
    WishListDaoIF wishListDaoIF = wishListService.getWishListById(UUID.randomUUID());
    return wishListDaoIF;
  }

}