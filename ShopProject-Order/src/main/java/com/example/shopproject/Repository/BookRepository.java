package com.example.shopproject.Repository;


import com.example.shopproject.Model.Entity.Book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findAllByGenre(String genre);
    List<Book> findAllByYear(Integer year);
    List<Book> findAllByGenreAndYear(String GEN, Integer AN);
    List<Book> queryByIsbn(String isbn);
}
