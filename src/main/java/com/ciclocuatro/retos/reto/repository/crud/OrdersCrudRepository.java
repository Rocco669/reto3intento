/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ciclocuatro.retos.reto.repository.crud;

import com.ciclocuatro.retos.reto.model.Orders;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Ronald
 */
public interface OrdersCrudRepository extends MongoRepository<Orders, Integer>{
    
    @Query("{'salesMan.zone': ?0}")
    List<Orders> findByZone(final String country);
    
    @Query("{status: ?0}")
    List<Orders> findByStatus(final String status);
    
    Optional<Orders> findTopByOrderByIdDesc();
}
