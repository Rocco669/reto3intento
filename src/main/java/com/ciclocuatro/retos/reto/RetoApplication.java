package com.ciclocuatro.retos.reto;

import com.ciclocuatro.retos.reto.model.User;
import com.ciclocuatro.retos.reto.repository.crud.OrdersCrudRepository;
import com.ciclocuatro.retos.reto.repository.crud.ProductoCrudRepository;
import com.ciclocuatro.retos.reto.repository.crud.UserCrudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetoApplication implements CommandLineRunner{
    
    @Autowired
    private UserCrudRepository userRepo;
    @Autowired
    private ProductoCrudRepository productoRepo;
    @Autowired
    private OrdersCrudRepository orderRepo;
    
    public static void main(String[] args) {
		SpringApplication.run(RetoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
