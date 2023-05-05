package com.eshop.backend.dto;


import com.eshop.backend.models.Product;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public record CategoryDTO (String name, Set<Product> products) {
    @JsonCreator
    public CategoryDTO(
            @JsonProperty("name") String name,
            @JsonProperty("products") Set<Product> products) {
        this.name = name;
        this.products = products;
    }

}

