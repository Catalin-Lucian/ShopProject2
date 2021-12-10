package com.example.shopproject.Model.Entity.Author;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class Author implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
}
