package com.cen4010.bookstore.wishlist.dao;

import com.google.common.base.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class WishListDaoImpl implements WishListDaoIF {

  @Id
  @SequenceGenerator(
      name = "wishlist",
      sequenceName = "wishlist_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "wishlist"
  )
  private UUID id;
  private UUID userId;
  private String name;

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public UUID getUserId() {
    return userId;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WishListDaoImpl wishList = (WishListDaoImpl) o;
    return Objects.equal(id, wishList.id)
        && Objects.equal(userId, wishList.userId)
        && Objects.equal(name, wishList.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, userId, name);
  }

  @Override
  public String toString() {
    return "WishListImpl{" +
        "id=" + id +
        ", userId=" + userId +
        ", name='" + name + '\'' +
        '}';
  }
}
