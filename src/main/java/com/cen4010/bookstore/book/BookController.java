package com.cen4010.bookstore.book;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="books")
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }
  @GetMapping("/create")
  public List<Book> getBook(){
    return bookService.getBook();
  }
  @GetMapping
  @ResponseBody
  public List<Book> getBook(@RequestParam(required = false) String genre){
    if (genre == null){
      return bookService.getBook();
    }
    else{
      List<Book> genreSearch = bookService.findByGenre(genre);
      return genreSearch;
    }
  }

  @PostMapping("/create")
  public void createNewBook(@RequestBody Book book){
    bookService.addNewBook(book);
  }

  @GetMapping("/author/{author}")
  public List<Book> getAuthor(@PathVariable("author") String author){
    List<Book> authorSearch = bookService.findByAuthor(author);
    return authorSearch;
  }

  @GetMapping("/genre/{genre}")
  public List<Book> getGenre(@PathVariable("genre") String genre){
    List<Book> genreSearch = bookService.findByGenre(genre);
    return genreSearch;
  }

  @GetMapping("/bestsellers")
  public List<Book> getMostSold(){
    List<Book> mostSoldBooks = bookService.findMostSold();
    return mostSoldBooks;
  }

  @GetMapping("/search")
  public Page<Book> pageSearch(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size){
    Page<Book> getBookPage = bookService.pageSearch(page, size);
    return getBookPage;
  }

}
