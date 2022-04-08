package com.cen4010.bookstore.book;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.hibernate.validator.constraints.ISBN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query("SELECT s FROM Book s WHERE s.ISBN = ?1")
    Optional<Book> confirmBookByIsbn(String ISBN);

    List<Book> findByGenre(String genre);

    List<Book> findTop10ByOrderByCopiesSoldDesc();

    List<Book> findByRatingGreaterThanEqualOrderByRatingDesc(double rating);

    List<Book> findBooksByAuthor(String author);

    @Query("SELECT a FROM Book a WHERE a.ISBN =?1")
    List<Book> findBookByIsbn(String ISBN);


}
