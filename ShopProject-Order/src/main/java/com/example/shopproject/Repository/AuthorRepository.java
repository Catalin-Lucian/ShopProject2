package com.example.shopproject.Repository;

import com.example.shopproject.Model.Entity.Author.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findAllByLastName(String lastName);

    List<Author> findAllByLastNameIsContaining(String lastName);
}
