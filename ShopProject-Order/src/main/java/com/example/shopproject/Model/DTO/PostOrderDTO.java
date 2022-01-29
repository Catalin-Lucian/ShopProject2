package com.example.shopproject.Model.DTO;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostOrderDTO implements DTO {
    public List<PostItemDTO> items= new ArrayList<PostItemDTO>();
}
