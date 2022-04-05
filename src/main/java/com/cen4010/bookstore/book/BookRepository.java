package com.cen4010.bookstore.book;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {



    List<Book> findByGenre(String genre);

    List<Book> findTop10ByOrderByCopiesSoldDesc();

    List<Book> findByAuthor(String author);

    @Query("Select s FROM Book s WHERE s.ISBN = ?1")
    Optional<Book> findBookByIsbn(String ISBN);

}
