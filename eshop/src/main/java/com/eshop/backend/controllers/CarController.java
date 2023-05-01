package com.eshop.backend.controllers;

import com.eshop.backend.services.CarService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "*", allowedHeaders ="*")

public class CarController {
    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/hello")
    public String sayHello() { return  "hello"; }
}
