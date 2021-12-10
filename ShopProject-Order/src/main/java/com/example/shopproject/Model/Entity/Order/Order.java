package com.example.shopproject.Model.Entity.Order;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.*;

@Data
public class Order {

    @MongoId
    private ObjectId id;
    private Date date = new Date();
    private List<Item> items= new ArrayList<Item>();
    private Status status;
}
