package com.cen4010.bookstore.book;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

  @Bean
  CommandLineRunner bookCommandLineRunner(BookRepository repository){
    return args -> {

    };
  }
}
