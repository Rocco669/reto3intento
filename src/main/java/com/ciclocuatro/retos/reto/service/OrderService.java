/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclocuatro.retos.reto.service;

import com.ciclocuatro.retos.reto.model.Orders;
import com.ciclocuatro.retos.reto.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ronald
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Orders> getAll(){
        return orderRepository.getAll();
    }
    
    public Optional<Orders> getOrder(int id){
        return orderRepository.getOrder(id);
    }
    
    public Orders create(Orders order) {
        
        //obtiene el maximo id existente en la coleccion
        Optional<Orders> orderIdMaxima = orderRepository.lastUserId();
        
        //si el id de la orden que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (order.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (orderIdMaxima.isEmpty())
                order.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        Optional<Orders> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.create(order);            
        }else{
            return order;
         } 
    }
    
    public Orders update(Orders order){
        if(order.getId() != null){
            Optional<Orders> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()){
                if (order.getStatus() != null){
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }
    
    public boolean delete(int id){
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Orders> findByZone(String zona){
        return orderRepository.findByZone(zona);
    }
    

}
