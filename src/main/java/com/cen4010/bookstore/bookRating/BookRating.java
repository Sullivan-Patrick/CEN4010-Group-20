package com.cen4010.bookstore.bookRating;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class BookRating {

    @Id
    private String id;
    private String userid;
    private String bookid;
    private int value;
    private String date;
    private String comment;

    public BookRating(String userid, String bookid, int value, String comment) {
        this.userid = userid;
        this.bookid = bookid;
        this.value = value;
        this.date = LocalDateTime.now().toString();
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}