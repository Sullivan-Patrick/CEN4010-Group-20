package com.cen4010.bookstore.bookRating;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public void deleteBookRating(UUID userid) {
        bookRatingRepository.deleteById(userid);
    }

    public void addBookRating(BookRating bookRating) {


        // validate the value passed for the rating (1-5 stars)
        int v = bookRating.getValue();
        if (v > 5 || v < 1) {
            throw new RuntimeException(String.format("Invalid value. Ratings must be between 1-5."));
        }

        // get a list of all ratings in the database by this user
        Optional<List<BookRating>> repositoryResults = bookRatingRepository.findByUserId(bookRating.getUserid());

        // if no ratings already exist for this user, go ahead and add the new rating (user/book were validated earlier)
        if (repositoryResults.isPresent() == false) {
            bookRatingRepository.insert(bookRating);
        }

        // some ratings do exist by this user
        else {

            // check that there is not already an existing rating by this user for the specified book
            List<BookRating> queryResultsForUser = repositoryResults.get();
            List<BookRating> queryResultsForUserAndBook = new ArrayList<>();
            for (BookRating r : queryResultsForUser) {
                if (r.getBookid().equals(bookRating.getBookid())) {
                    queryResultsForUserAndBook.add(r);
                }
            }

            // no rating by this user for this book, so insert it
            if (queryResultsForUserAndBook.size() == 0) {
                bookRatingRepository.insert(bookRating);
            }

            // rating for this book by this user already exists, so throw error
            // PUT API should be used to update instead of insert
            else {
                throw new RuntimeException(String.format("Found Existing Rating for Book ID %s by User ID %s", bookRating.getBookid(), bookRating.getUserid()));
            }
        }
    }

    public void updateBookRating(BookRating bookRating) {


        // validate the value passed for the rating (1-5 stars)
        int v = bookRating.getValue();
        if (v > 5 || v < 1) {
            throw new RuntimeException(String.format("Invalid value. Ratings must be between 1-5."));
        }

        // get a list of all ratings in the database by this user
        Optional<List<BookRating>> repositoryResults = bookRatingRepository.findByUserId(bookRating.getUserid());

        // if no ratings by this user exist, we cannot update one so throw an error
        // POST API should be used to insert new ratings instead of update
        if (repositoryResults.isPresent() == false) {
            throw new RuntimeException(String.format("Cannot find Ratings by User %s", bookRating.getUserid()));
        }

        // some ratings by this user exist, so find the one for the specified book if it exists
        else {
            List<BookRating> queryResultsForUser = repositoryResults.get();
            List<BookRating> queryResultsForUserAndBook = new ArrayList<>();
            for (BookRating r : queryResultsForUser) {
                if (r.getBookid().equals(bookRating.getBookid())) {
                    queryResultsForUserAndBook.add(r);
                }
            }

            // could not find a rating for the specified book by this user, so throw an error
            // POST API should be used to insert new ratings instead of update
            if (queryResultsForUserAndBook.size() == 0) {
                throw new RuntimeException(String.format("Cannot Find Rating for Book ID %s by User ID %s", bookRating.getBookid(), bookRating.getUserid()));
            }

            // for some reason, multiple ratings for the specified book by this user were found, so throw an error
            // only one rating should exist per user per book
            else if (queryResultsForUserAndBook.size() > 1) {
                throw new RuntimeException(String.format("Found Duplicate Ratings for Book ID %s by User ID %s", bookRating.getBookid(), bookRating.getUserid()));
            }

            // only one rating by this user for the specified book exists, so update it
            else {
                BookRating savedBookRating = queryResultsForUserAndBook.get(0);

                savedBookRating.setUserid(bookRating.getUserid());
                savedBookRating.setBookid(bookRating.getBookid());
                savedBookRating.setDate(bookRating.getDate());
                savedBookRating.setValue(bookRating.getValue());
                savedBookRating.setComment(bookRating.getComment());

                bookRatingRepository.save(savedBookRating);
            }
        }

    }

    // Extended API services

    public List<BookRating> getBookRatingsByUser(UUID userId) {

        return bookRatingRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Ratings by User %s", userId)
        ));
    }

    public List<BookRating> getBookRatingsByBook(String bookId) {

        return bookRatingRepository.findByBookId(bookId).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find Ratings for Book %s", bookId)
        ));
    }

    public List<BookRating> getBookRatingsSortedDes() {
        List<BookRating> unsortedBookRatings = getAllBookRatings();
        unsortedBookRatings.sort(new BookRatingSortedByValueDes());

        return unsortedBookRatings;
    }

    public List<BookRating> getBookRatingsSortedAsc() {
        List<BookRating> unsortedBookRatings = getAllBookRatings();
        unsortedBookRatings.sort(new BookRatingSortedByValueAsc());

        return unsortedBookRatings;
    }

    public float getAverageBookRating(String bookid) {

        List<BookRating> allBookRatingsByBook = getBookRatingsByBook(bookid);
        long sum = 0;

        for (BookRating r : allBookRatingsByBook) {
            sum += r.getValue();
        }

        return sum / (float) allBookRatingsByBook.size();
    }

}
