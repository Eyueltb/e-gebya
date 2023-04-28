package com.eshop.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name ="cars")
public class Car {
    @Id
    private Long id;
    private String model;
    private String description;
    private int productionYear;
    private String passengerCapacity;
    private LocalDate dateImported;
    //picture,

    public Car(String model,String description,int productionYear,String passengerCapacity,LocalDate dateImported){
        this.id= UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.model=model;
        this.description=description;
        this.productionYear=productionYear;
        this.passengerCapacity=passengerCapacity;
        this.dateImported=dateImported;
    }
}
