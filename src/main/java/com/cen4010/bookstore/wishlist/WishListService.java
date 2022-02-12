package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.wishlist.dao.WishListDaoIF;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WishListService {

  private final WishListRepository wishListRepository;

  @Autowired
  public WishListService(WishListRepository wishListRepository) {
    this.wishListRepository = wishListRepository;
  }

  public WishListDaoIF getWishListById(UUID wishlistId) {
    return wishListRepository.findById(wishlistId).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  //todo: move filtering logic to repository
  public List<WishListDaoIF> getUserWishLists(UUID userId) {
    return wishListRepository.findAll().stream()
        .filter(wishList -> wishList.getUserId().equals(userId))
        .collect(Collectors.toList());
  }
}
