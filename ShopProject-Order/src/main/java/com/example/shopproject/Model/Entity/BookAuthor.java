package com.example.shopproject.Model.Entity;

import lombok.Data;

import javax.persistence.*;


@Data
public class BookAuthor {

    private Integer id;
    private String isbn;
    private Integer idAuthor;
}
