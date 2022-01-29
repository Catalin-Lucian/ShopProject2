package com.example.shopproject.Controller;


import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Book.PostBookDTO;
import com.example.shopproject.Model.DTO.DTO;
import com.example.shopproject.Model.DTO.Order.PostItemDTO;
import com.example.shopproject.Model.Entity.BookAuthor;
import com.example.shopproject.Service.BookAuthorService;
import com.example.shopproject.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/bookcollection/books")
public class BookController {

    final BookService bookService;
    final BookAuthorService bookAuthorService;

    public BookController(BookService bookService, BookAuthorService bookAuthorService) {
        this.bookService = bookService;
        this.bookAuthorService = bookAuthorService;
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<DTO> GetBookByISBN(@PathVariable String isbn, @RequestParam(required = false, defaultValue = "true") String verbose) {
        if (Objects.equals(verbose, "true"))
            return ResponseEntity.ok(bookService.GetBookByIsbn(isbn));
        else if (Objects.equals(verbose, "false")){
            return ResponseEntity.ok(bookService.GetPartialBookByIsbn(isbn));
        } else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public void PostBook(@RequestBody PostBookDTO postBookDTO) {
        bookService.PostBook(postBookDTO);
    }

    @DeleteMapping
    public void DeleteBook(@RequestParam String ISBN) {
        bookService.DeleteBook(ISBN);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> GetAllBooks() {
        return ResponseEntity.ok(bookService.GetAllBooks());
    }

    @GetMapping("/{isbn}/authors")
    public ResponseEntity<List<AuthorDTO>> GetIDAuthorsForBook(@PathVariable String isbn) {
        return ResponseEntity.ok(bookAuthorService.GetIdAuthorsForBook(isbn));
    }

    @PostMapping("/{idAuthor}/authors/{isbn}")
    public void PostBookAuthor(@PathVariable Integer idAuthor, @PathVariable String isbn) {
        bookAuthorService.PostBookAuthor(new BookAuthor(isbn, idAuthor));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> GetBooksPerPage(@RequestParam Integer page, @RequestParam(required = false, defaultValue = "10") Integer itemsPerPage) {
        return ResponseEntity.ok(bookService.GetBooksPerPage(page, itemsPerPage));
    }

    @GetMapping("/find")
    public ResponseEntity<List<BookDTO>> GetBooksByGenreYear(@RequestParam(required = false, defaultValue = "") String GENRE, @RequestParam(required = false, defaultValue = "0") Integer YEAR) {
        if (!Objects.equals(GENRE, "") && YEAR != 0) {
            return ResponseEntity.ok(bookService.GetBooksByGenreAndYear(GENRE, YEAR));
        } else if (!Objects.equals(GENRE, "")) {
            return ResponseEntity.ok(bookService.GetBooksByGenre(GENRE));
        } else if (YEAR != 0) {
            return ResponseEntity.ok(bookService.GetBooksByYear(YEAR));
        } else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/updateStock")
    public ResponseEntity<BookDTO> UpdateStock(@RequestBody PostItemDTO item){
        var book = bookService.UpdateStockForItem(item);
        if (book!= null) return ResponseEntity.ok(book);
        else return ResponseEntity.badRequest().build();

    }


}
