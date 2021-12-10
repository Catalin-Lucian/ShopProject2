package com.example.shopproject.Model.Entity;

import javax.persistence.*;


@Entity
@Table(name = "book_author")
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "id_author")
    private Integer idAuthor;

    public BookAuthor() {
    }

    public BookAuthor(String isbn, Integer idAuthor) {
        this.isbn = isbn;
        this.idAuthor = idAuthor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }
}
