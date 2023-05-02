package com.eshop.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name ="cars")
public class Car {
    @Id
    private Long id;
    @Column(nullable = false)
    private String model;

    private String description;

    @Column(nullable = false)
    private Integer productionYear;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Integer mileage;

    @Column(nullable = false)
    private BigDecimal price;


    private String passengerCapacity;
    private LocalDate dateImported;
    //picture,

    @ManyToOne
    private Location location;

    @ManyToOne
    private User seller;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Image> images;

    public Car(String model,String description, Integer productionYear,String passengerCapacity,LocalDate dateImported){
        this.id= UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.model=model;
        this.description=description;
        this.productionYear=productionYear;
        this.passengerCapacity=passengerCapacity;
        this.dateImported=dateImported;
    }
}
