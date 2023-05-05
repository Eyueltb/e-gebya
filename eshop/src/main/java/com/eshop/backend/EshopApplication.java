package com.eshop.backend;

import com.eshop.backend.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EshopApplication implements CommandLineRunner {
    private final ProductRepository productRepository;

    public EshopApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Product p = new Product();
    }
}
