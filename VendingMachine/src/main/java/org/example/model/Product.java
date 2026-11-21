package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Product {
    private String id;
    private String name;
    private double price;
}
