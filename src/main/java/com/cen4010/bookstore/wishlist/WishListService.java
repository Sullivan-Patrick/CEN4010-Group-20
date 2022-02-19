package com.cen4010.bookstore.wishlist;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.naming.LimitExceededException;
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

  public WishList create(String name, UUID userId) throws LimitExceededException {
    //todo: make this use JPA to filter once user dao is made
    List<WishList> wishLists = wishListRepository.findAll().stream()
        .filter(wishList -> wishList.getId().equals(userId))
        .collect(Collectors.toList());

    validateNewWishList(wishLists);

    return wishListRepository.save(new WishList(
        UUID.randomUUID(),
        userId,
        name
    ));
  }

  public WishList getWishListById(UUID wishlistId) {
    return wishListRepository.findById(wishlistId).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  //todo: move filtering logic to repository
  public List<WishList> getUserWishLists(UUID userId) {
    return wishListRepository.findAll().stream()
        .filter(wishList -> wishList.getUserId().equals(userId))
        .collect(Collectors.toList());
  }

  //todo: validate user exists, wishlist name isnt used yet
  private void validateNewWishList(
      List<WishList> wishLists
  ) throws LimitExceededException {
    if (wishLists.size() >= 3) {
      throw new LimitExceededException("User cannot have more than 3 wishlists");
    }


  }
}
