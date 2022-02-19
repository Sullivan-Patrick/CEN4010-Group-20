package com.cen4010.bookstore.book;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

  @Bean
  CommandLineRunner commandLineRunner(BookRepository repository){
    return args -> {
      Book dune = new Book(
          "10000000001",
          "Dune",
          "This is a test book",
          19.99,
          "Frank Herbert",
          "scifi",
          "Group 20",
          2022,
          1
      );
      Book harryPotter = new Book(
          "1000200002",
          "Harry Potter",
          "This is a test book",
          19.99,
          "JK Rowling",
          "fantasy",
          "Group 20",
          2022,
          1
      );
      Book beowulf = new Book(
          "3000300003",
          "Beowulf",
          "This is a test book",
          19.99,
          "A Viking",
          "fantasy",
          "Group 20",
          1066,
          1
      );
      Book wheelOfTime = new Book(
          "5067400003",
          "Wheel Of Time",
          "This is a test book",
          19.99,
          "Robert Jordan",
          "fantasy",
          "Group 20",
          2022,
          1
      );
      Book leaguesUnder = new Book(
          "1000678420",
          "20,000 Leagues Under the Sea",
          "This is a test book",
          19.99,
          "Jules Verne",
          "scifi",
          "Group 20",
          2022,
          1
      );
      Book outsider = new Book(
          "1X-0277002",
          "The Outsiders",
          "This is a test book",
          19.99,
          "SE Hinton",
          "youngadult",
          "Group 20",
          2022,
          1
      );
      Book percy = new Book(
          "X-33200002",
          "Percy Jackson",
          "This is a test book",
          19.99,
          "Rick Riordan",
          "fantasy",
          "Group 20",
          2022,
          1
      );
      Book ender = new Book(
          "770020X402",
          "Ender's Game",
          "This is a test book",
          19.99,
          "Orson Scott Card",
          "scifi",
          "Group 20",
          2022,
          1
      );
      Book testBook = new Book(
          "1020-207892",
          "Fall of The Roman Empire",
          "This is a test book",
          19.99,
          "An Author",
          "history",
          "Group 20",
          2022,
          1
      );
      Book threeKings = new Book(
          "Wei-Wu-Shu-Jin",
          "Romance of The Three Kingdoms",
          "This is a test book",
          19.99,
          "Luo Guanzhong",
          "history",
          "Group 20",
          1522,
          3
      );

      repository.saveAll(
          List.of(dune, harryPotter, beowulf, wheelOfTime, leaguesUnder, outsider,percy, ender, testBook, threeKings)
      );
    };
  }
}