package com.cen4010.bookstore.author;

import com.cen4010.bookstore.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {

    @Query("SELECT s FROM Author s WHERE s.e_fullName = ?1")
    Optional<Author> findByName(String fullName);

}
