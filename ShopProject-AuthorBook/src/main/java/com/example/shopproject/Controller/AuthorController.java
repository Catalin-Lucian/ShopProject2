package com.example.shopproject.Controller;

import com.example.shopproject.Model.DTO.Author.AuthorDTO;
import com.example.shopproject.Model.DTO.Author.PostAuthorDTO;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.Order.PostItemDTO;
import com.example.shopproject.Service.AuthorService;
import com.example.shopproject.Service.BookAuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping(value = "/api/bookcollection/authors")
public class AuthorController {

    final AuthorService authorService;
    final BookAuthorService bookAuthorService;

    public AuthorController(AuthorService authorService, BookAuthorService bookAuthorService) {
        this.authorService = authorService;
        this.bookAuthorService = bookAuthorService;
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<AuthorDTO> GetAuthorByID(@RequestParam Integer id) {
        return ResponseEntity.ok(authorService.GetAuthorByID(id));
    }

    @PostMapping
    public void PostAuthor(@RequestBody PostAuthorDTO postAuthorDTO) {
        authorService.PostAuthor(postAuthorDTO);
    }

    @DeleteMapping
    public void DeleteAuthor(@RequestParam Integer id) {
        authorService.DeleteAuthor(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDTO>> GetAllAuthors() {
        return ResponseEntity.ok(authorService.GetAllAuthors());
    }

    @GetMapping("/{idAuthor}/books")
    public ResponseEntity<List<BookDTO>> GetAllBooksForAuthor(@PathVariable Integer idAuthor) {
        return ResponseEntity.ok(bookAuthorService.GetAllBooksForAuthor(idAuthor));
    }

    @GetMapping("/find")
    public ResponseEntity<List<AuthorDTO>> GetAllAuthorsByName(
            @RequestParam String lastName,
            @RequestParam(required = false, defaultValue = "") String match) {
        if (Objects.equals(match, "exact"))
            return ResponseEntity.ok(authorService.GetAuthorByExactLastName(lastName));
        else
            return ResponseEntity.ok(authorService.GetAuthorByApproximativeLastName(lastName));
    }


}
