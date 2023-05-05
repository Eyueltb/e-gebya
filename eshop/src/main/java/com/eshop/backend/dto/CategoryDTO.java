package com.eshop.backend.dto;


import com.eshop.backend.models.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Set;

public record CategoryDTO (String name, Set<Product> products) {
    @JsonCreator
    public CategoryDTO(
            @JsonProperty("name") String name,
            @JsonProperty("products") Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Set<Product> products() {
        return products;
    }
}

