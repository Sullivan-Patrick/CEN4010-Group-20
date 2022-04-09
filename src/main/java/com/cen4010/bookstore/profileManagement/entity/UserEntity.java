package com.cen4010.bookstore.profileManagement.entity;

import com.cen4010.bookstore.book.Book;
import com.cen4010.bookstore.profileManagement.dto.UserDto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  private UUID id; // changed to UUID

  @Column(name = "Username", unique = true)
  private String username;

  @Column(name = "Password")
  private String password;

  @Column(name = "Full_Name")
  private String fullName;

  @Column(name = "Phone_Number")
  private String phoneNumber;

  @ManyToMany
  @JoinTable(
      name = "in_shopping_cart",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id")
  )
  private Set<Book> booksInCart = new HashSet<>();

  public UserDto toDto(){
    UserDto entity = new UserDto();
    BeanUtils.copyProperties(this, entity);
    return entity;
  }

  public void addBookToCart(Book book) {
    booksInCart.add(book);
  }
}
