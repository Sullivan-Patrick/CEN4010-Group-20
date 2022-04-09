package com.cen4010.bookstore.bookRating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRating, UUID> {

    @Query("{'userid': ?0}")
    Optional<List<BookRating>> findByUserId(UUID userid);

    @Query("{'bookid': ?0}")
    Optional<List<BookRating>> findByBookId(String bookid);

    void insert(BookRating bookRating);
}
