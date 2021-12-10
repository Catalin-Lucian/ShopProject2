package com.example.shopproject.Model.DTO.Author;

import com.example.shopproject.Model.DTO.DTO;
import lombok.Data;

@Data
public class PostAuthorDTO implements DTO {
    private String firstName;
    private String lastName;
}