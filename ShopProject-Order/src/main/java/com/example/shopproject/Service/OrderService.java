package com.example.shopproject.Service;

import com.example.shopproject.Mapper.OrderMapper;
import com.example.shopproject.Model.DTO.Order.PostOrderDTO;
import com.example.shopproject.Model.Entity.Order.Item;
import com.example.shopproject.Model.Entity.Order.Order;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(),
            "book-order"));


    public void PostOrder(PostOrderDTO postOrderDTO, Integer idUser) {
        Order order = OrderMapper.convertToOrder(postOrderDTO);
        List<Item> items = order.getItems();
        for (Item item : items) {
            // Book book = bookService.GetBookByIsbn(item.getIsbn());

        }
        mongoOps.insert(order, "Client." + idUser);
    }

    public void DeleteAllOrders(Integer idUser) {
        mongoOps.dropCollection("Client." + idUser);
    }

//    public List<Order> GetOrders(Integer idUser){
//        return mongoOps. ("Client."+idUser).;
//    }
}
