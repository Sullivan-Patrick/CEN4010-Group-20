package com.cen4010.bookstore.bookRating;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
<<<<<<< HEAD
    @RequestMapping("/api/book")
=======
    @RequestMapping("/api/bookRating")
>>>>>>> b0dc2953edae40cd21ff580c9efc22bae76dadff
    public class BookRatingController {

        private final BookRatingService bookRatingService;

        public BookRatingController(BookRatingService bookRatingService) {
            this.bookRatingService = bookRatingService;
        }


    }
