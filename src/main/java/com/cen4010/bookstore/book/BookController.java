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
  public void createBook(@RequestBody Book book){
    bookService.addBook(book);
  }

  @GetMapping("/byAuthor/{author}")
  public List<Book> getAuthor(@PathVariable("author") String author){
    List<Book> authorSearch = bookService.findBooksByAuthor(author);
    return authorSearch;
  }

  @GetMapping("/byIsbn/{ISBN}")
  public List<Book> getBookByIsbn(@PathVariable("ISBN") String ISBN){
    List<Book> isbnSearch = bookService.findBookByIsbn(ISBN);
    return isbnSearch;
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
