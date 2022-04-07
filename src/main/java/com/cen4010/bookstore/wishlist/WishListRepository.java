package com.cen4010.bookstore.wishlist;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList, UUID> {
  List<WishList> findByUserId(UUID userId);
}
