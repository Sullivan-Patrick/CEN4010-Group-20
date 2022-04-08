package com.cen4010.bookstore.author;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }

    @PostMapping
    public void createAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
    }
}

