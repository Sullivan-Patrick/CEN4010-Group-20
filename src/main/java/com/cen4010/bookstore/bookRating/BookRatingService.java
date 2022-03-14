package com.cen4010.bookstore.bookRating;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookRatingService {

    private final BookRatingRepository bookRatingRepository;

    public BookRatingService(BookRatingRepository bookRatingRepository) {
        this.bookRatingRepository = bookRatingRepository;
    }

    // Basic CRUD operation services

    public List<BookRating> getAllBookRatings() {
        return bookRatingRepository.findAll();
    }

    public void deleteBookRating(String id) {
        bookRatingRepository.deleteById(id);
    }


}

