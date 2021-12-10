package com.example.shopproject.Model.Entity.Book;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
