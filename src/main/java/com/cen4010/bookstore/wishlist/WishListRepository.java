package com.cen4010.bookstore.wishlist;

import com.cen4010.bookstore.wishlist.dao.WishListDaoIF;
import com.cen4010.bookstore.wishlist.dao.WishListDaoImpl;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//todo: verify generics work with interfaces and change if not

@Repository
public interface WishListRepository extends JpaRepository<WishListDaoImpl, UUID> {}
