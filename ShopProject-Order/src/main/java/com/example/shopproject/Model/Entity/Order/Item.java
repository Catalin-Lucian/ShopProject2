package com.example.shopproject.Model.Entity.Order;

import lombok.Data;

@Data
public class Item {
    String isbn;
    String title;
    Float price;
    Integer quantity;
}
