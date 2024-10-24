package org.example.tp2;

import org.example.tp2.JPA_entite.product;
import org.example.tp2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {

        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        productRepository.save(new product(null,"Computer",4300,3));
        productRepository.save(new product(null,"Sprinter",3800,43));
        productRepository.save(new product(null,"Smart phone",6090,20));

        List<product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });

        product product = productRepository.findById(Long.valueOf(1)).get();

        System.out.println("****************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("*******************");



        System.out.println("-------------");
        List<product> productList = productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });



        System.out.println("-------------");
        List<product> productList2 = productRepository.search("%C%");
        productList.forEach(p->{
            System.out.println(p);
        });
    }
}
