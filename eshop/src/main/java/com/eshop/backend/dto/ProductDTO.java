package com.eshop.backend.dto;

import com.eshop.backend.models.Category;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.math.BigDecimal;


public record ProductDTO(String name, String description, BigDecimal price, Category category) {
    @JsonCreator
    public ProductDTO(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("category") Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public BigDecimal price() {
        return price;
    }

    @Override
    public Category category() {
        return category;
    }
}
