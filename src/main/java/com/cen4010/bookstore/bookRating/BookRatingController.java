package com.cen4010.bookstore.bookRating;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/bookRating")
    public class BookRatingController {

        private final BookRatingService bookRatingService;

        public BookRatingController(BookRatingService bookRatingService) {
            this.bookRatingService = bookRatingService;
        }


    }
