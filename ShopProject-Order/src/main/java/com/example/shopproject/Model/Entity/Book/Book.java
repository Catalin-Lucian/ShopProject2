package com.example.shopproject.Model.Entity.Book;


import lombok.Data;
import java.io.Serializable;

@Data
public class Book implements Serializable {

    private String isbn;
    private String title;
    private String publisher;
    private Integer year;
    private String genre;
    private Integer stock;
    private Float price;
}
