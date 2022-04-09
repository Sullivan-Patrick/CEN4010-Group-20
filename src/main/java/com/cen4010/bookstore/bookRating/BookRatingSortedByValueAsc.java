package com.cen4010.bookstore.bookRating;

import java.util.Comparator;

public class BookRatingSortedByValueAsc implements Comparator<BookRating> {

    @Override
    public int compare(BookRating r1, BookRating r2) {
        return r1.getValue() - r2.getValue();
    }
}