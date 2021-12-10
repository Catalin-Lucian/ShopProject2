package com.example.shopproject.Model.DTO.Order;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostOrderDTO {
    public List<PostItemDTO> items= new ArrayList<PostItemDTO>();
}
