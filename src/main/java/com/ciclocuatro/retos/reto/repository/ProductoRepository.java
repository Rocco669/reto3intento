/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclocuatro.retos.reto.repository;

import com.ciclocuatro.retos.reto.model.Productos;
import com.ciclocuatro.retos.reto.repository.crud.ProductoCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ronald
 */
@Repository
public class ProductoRepository {
    @Autowired
    public ProductoCrudRepository repository;

    public List<Productos> getAll() {
        return repository.findAll();
    }

    public Optional<Productos> getClothe(int id) {
        return repository.findById(id);
    }
    public Productos create(Productos clothe) {
        return repository.save(clothe);
    }

    public void update(Productos clothe) {
        repository.save(clothe);
    }
    
    public void delete(Productos clothe) {
        repository.delete(clothe);
    }
}
