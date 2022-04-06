package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.book.Book;
import com.cen4010.bookstore.book.BookRepository;
import com.cen4010.bookstore.profileManagement.entity.UserEntity;
import com.cen4010.bookstore.profileManagement.repository.UserRepository;
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
  private final BookRepository bookRepository;
  private final UserRepository userRepository;

  @Autowired
  public WishListService(WishListRepository wishListRepository,
      BookRepository bookRepository,
      UserRepository userRepository
  ) {
    this.wishListRepository = wishListRepository;
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
  }

  public WishList create(String name, UUID userId) throws LimitExceededException {
    //todo: make this use JPA to filter once user dao is made
    List<WishList> wishLists = wishListRepository.findAll().stream()
        .filter(wishList -> wishList.getUserId().equals(userId))
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
        new ResponseStatusException(HttpStatus.BAD_REQUEST));
  }

  //todo: use this method and make an endpoint for it
  public List<WishList> getUserWishLists(UUID userId) {
    return wishListRepository.findAll().stream()
        .filter(wishList -> wishList.getUserId().equals(userId))
        .collect(Collectors.toList());
  }

  public void add(UUID bookId, UUID wishListId) {
    Book book =  bookRepository.getById(bookId);
    WishList wishList = wishListRepository.getById(wishListId);
    wishList.addBook(book);
    wishListRepository.save(wishList);
  }

  //todo: validate user exists, wishlist name isnt used yet
  private void validateNewWishList(
      List<WishList> wishLists
  ) throws LimitExceededException {
    if (wishLists.size() >= 3) {
      throw new LimitExceededException("User cannot have more than 3 wishlists");
    }
  }


  public void toCart(UUID bookId, UUID wishListId, UUID userId) {
    Book book =  bookRepository.getById(bookId);
    WishList wishList = wishListRepository.getById(wishListId);
    UserEntity user = userRepository.findById(userId).get();

    if (!wishList.getBooks().contains(book)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    wishList.removeBook(book);
    user.addBookToCart(book);

    userRepository.save(user);
    wishListRepository.save(wishList);
  }
}
