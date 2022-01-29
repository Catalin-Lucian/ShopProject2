package com.example.shopproject.Service;

import com.example.shopproject.Mapper.OrderMapper;
import com.example.shopproject.Model.DTO.Book.BookDTO;
import com.example.shopproject.Model.DTO.PostOrderDTO;
import com.example.shopproject.Model.Entity.Order.Item;
import com.example.shopproject.Model.Entity.Order.Order;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(),
            "book-order"));

    RestTemplate restTemplate = new RestTemplate();

    public void PostOrder(PostOrderDTO postOrderDTO, Long idUser) {
        String bookUri = "http://localhost:8080/api/bookcollection/books/updateStock";
        Order order = OrderMapper.convertToOrder(postOrderDTO);

        List<Item> orderItems = new ArrayList<>();
        for (Item item : order.getItems()) {
            BookDTO bookDTO = restTemplate.postForObject(bookUri, OrderMapper.convertToItemDTO(item), BookDTO.class);
            if (bookDTO!=null){
                item.setPrice(bookDTO.getPrice());
                item.setTitle(bookDTO.getTitle());
                orderItems.add(item);
            }

        }
        order.setItems(orderItems);
        mongoOps.insert(order, "Client." + idUser);
    }

    public void DeleteAllOrders(Long idUser) {
        mongoOps.dropCollection("Client." + idUser);
    }

    public List<Order> GetOrders(Long idUser){
        return mongoOps.findAll(Order.class, "Client."+idUser);

    }
}
