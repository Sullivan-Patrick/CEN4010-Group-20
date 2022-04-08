package com.cen4010.bookstore.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }

    public void addAuthor(Author author){
        Optional<Author> authorOptional = authorRepository.findByName(author.getFullName());
        if(authorOptional.isPresent()){
            throw new IllegalStateException("Author already exists.");
        }
        authorRepository.save(author);
    }

}

