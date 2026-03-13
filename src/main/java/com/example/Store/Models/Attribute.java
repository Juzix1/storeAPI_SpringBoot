package com.example.Store.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String attributeValue;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;


    public Attribute(String name, String attributeValue, Product product) {
        this.name = name;
        this.attributeValue = attributeValue;
        this.product = product;
    }

}
