package com.example.shopproject.Model.DTO.Author;

import com.example.shopproject.Model.DTO.DTO;
import lombok.Data;

@Data
public class AuthorDTO implements DTO {
    private Integer id;
    private String firstName;
    private String lastName;
}
