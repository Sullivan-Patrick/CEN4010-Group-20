package com.cen4010.bookstore.author;

import org.checkerframework.checker.units.qual.C;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.UUID;

@Entity
@Table
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "first_name")
    private String a_firstName;
    @Column(name = "last_name")
    private String b_lastName;
    @Column(name = "publisher")
    private String c_publisher;
    @Column(name = "biography")
    private String d_biography;
    @Column(name = "full_name")
    private String e_fullName;

    public Author(){

    }

    public String getFullName(){
        e_fullName = a_firstName + " " + b_lastName;
        return e_fullName;
    }


    public Author(String a_firstName, String b_lastName, String d_biography, String c_publisher) {
        this.a_firstName = a_firstName;
        this.b_lastName = b_lastName;
        this.d_biography = d_biography;
        this.c_publisher = c_publisher;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getFirstName() {
        return a_firstName;
    }

    public void setFirstName(String a_firstName) {
        this.a_firstName = a_firstName;
    }

    public String getLastName(){
        return b_lastName;
    }

    public void setLastName(String b_lastName){
        this.b_lastName = b_lastName;
    }


    public String getBiography() {
        return d_biography;
    }

    public void setBiography(String d_biography) {
        this.d_biography = d_biography;
    }

    public String getPublisher() {
        return c_publisher;
    }

    public void setPublisher(String c_publisher) {
        this.c_publisher = c_publisher;
    }


}

