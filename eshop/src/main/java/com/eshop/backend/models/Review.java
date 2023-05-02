package com.eshop.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "reviews")
public class Review {

    @Id
    private Long id;

    @ManyToOne
    private User reviewer;

    @ManyToOne
    private Car car;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private String comments;

}

