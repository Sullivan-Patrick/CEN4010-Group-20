package com.cen4010.bookstore.bookRating;

import java.util.Comparator;

public class BookRatingSortedByValueDes implements Comparator<BookRating> {

    @Override
    public int compare(BookRating r1, BookRating r2) {
        return r2.getValue() - r1.getValue();
    }
}