package com.cen4010.bookstore.bookRating;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "bookRating")
public class BookRatingController {

    private final BookRatingService bookRatingService;

    @Autowired
    public BookRatingController(BookRatingService bookRatingService) {
        this.bookRatingService = bookRatingService;
    }


    @PostMapping
    public ResponseEntity addBookRating(@RequestBody BookRating bookRating) {
        bookRatingService.addBookRating(bookRating);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<BookRating>> getAllBookRatings() {
        return ResponseEntity.ok(bookRatingService.getAllBookRatings());
    }

    @PutMapping
    public ResponseEntity updateBookRating(@RequestBody BookRating bookRating) {
        bookRatingService.updateBookRating(bookRating);
        return ResponseEntity.ok(bookRatingService.getAllBookRatings());
    }


    // Additional API functionality

    @GetMapping("/byuser/{userid}")
    public ResponseEntity<List<BookRating>> getBookRatingsByUser(@PathVariable UUID userid) {
        return ResponseEntity.ok(bookRatingService.getBookRatingsByUser(userid));
    }

    @GetMapping("/allbooks/sorted/highest")
    public ResponseEntity<List<BookRating>> getBookRatingsByBookSortedDes() {
        return ResponseEntity.ok(bookRatingService.getBookRatingsSortedDes());
    }

    @GetMapping("/allbooks/sorted/lowest")
    public ResponseEntity<List<BookRating>> getBookRatingsByBookSortedAsc() {
        return ResponseEntity.ok(bookRatingService.getBookRatingsSortedAsc());
    }

    @GetMapping("/avg/{bookid}")
    public ResponseEntity getAverageBookRating(@PathVariable String bookid) {
        return ResponseEntity.ok(bookRatingService.getAverageBookRating(bookid));
    }

}