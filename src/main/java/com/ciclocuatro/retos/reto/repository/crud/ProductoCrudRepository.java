/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ciclocuatro.retos.reto.repository.crud;

import com.ciclocuatro.retos.reto.model.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Ronald
 */
public interface ProductoCrudRepository extends MongoRepository<Productos, Integer>{
    
}
