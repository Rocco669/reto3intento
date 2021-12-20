/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclocuatro.retos.reto.repository;

import com.ciclocuatro.retos.reto.model.Orders;
import com.ciclocuatro.retos.reto.repository.crud.OrdersCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ronald
 */
@Repository
public class OrderRepository {
    
    @Autowired
    public OrdersCrudRepository repository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Orders> getAll() {
        return (List<Orders>) repository.findAll();
    }
    
    public Optional<Orders> getOrder(int id){
        return repository.findById(id);
    }
    
    public Orders create(Orders order){
        return repository.save(order);
    }
    
    public void update(Orders order){
        repository.save(order);
    }
    
    public void delete(Orders order){
        repository.delete(order);
    }
    
    public List<Orders> findByZone(String zona){
        return repository.findByZone(zona);
    }
    
    public Optional<Orders> lastUserId(){
        return repository.findTopByOrderByIdDesc();
    }

}
