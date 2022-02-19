package com.cen4010.bookstore.book;

import com.cen4010.bookstore.wishlist.WishList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Book {

  @Id
  @Column(name = "id")
  @Type(type = "uuid-char")
  private UUID isbn;
  private String name;

  @ManyToMany(mappedBy = "books")
  private Set<WishList> wishListsWithBook = new HashSet<>();

  public UUID getIsbn() {
    return isbn;
  }

  public String getName() {
    return name;
  }

  public Set<WishList> getWishListsWithBook() {
    return wishListsWithBook;
  }
}
