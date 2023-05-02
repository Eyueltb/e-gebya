package com.eshop.backend;

import com.eshop.backend.models.Car;
import com.eshop.backend.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class EshopApplication implements CommandLineRunner {
    private final CarRepository carRepository;

    public EshopApplication(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Car car = new Car("model-1", "Car description", 2022, "four", LocalDate.of(2023, 10, 20 ));
       // carRepository.save(car);
    }
}
