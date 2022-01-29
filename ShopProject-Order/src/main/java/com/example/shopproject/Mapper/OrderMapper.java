package com.example.shopproject.Mapper;

import com.example.shopproject.Model.DTO.PostItemDTO;
import com.example.shopproject.Model.DTO.PostOrderDTO;
import com.example.shopproject.Model.Entity.Order.Item;
import com.example.shopproject.Model.Entity.Order.Order;

import java.util.stream.Collectors;

public class OrderMapper {
    public static Item convertToItem(PostItemDTO postItemDTO){
        Item item=new Item();
        item.setIsbn(postItemDTO.getIsbn());
        item.setQuantity(postItemDTO.getQuantity());
        return item;
    }

    public static PostItemDTO convertToItemDTO(Item item){
        PostItemDTO postItemDTO=new PostItemDTO();
        postItemDTO.setIsbn(item.getIsbn());
        postItemDTO.setQuantity(item.getQuantity());
        return postItemDTO;
    }

    public static Order convertToOrder(PostOrderDTO postOrderDTO){
        Order order=new Order();
        order.setItems(postOrderDTO.getItems().stream().map(OrderMapper::convertToItem).collect(Collectors.toList()));
        return order;
    }

}
