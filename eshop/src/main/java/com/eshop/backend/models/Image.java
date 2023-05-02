package com.eshop.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "images")
public class Image {
    @Id private Long id;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    private Car car;
}

