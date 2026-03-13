package com.example.Store.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    @JsonManagedReference
    private Producer producer;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<Attribute> attributes = new ArrayList<>();

    public Product(String name, String description, Double price, Producer producer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.producer = producer;
    }


    public void addAttribute(Attribute att){
        attributes.add(att);
    }
    public void removeAttribute(Attribute att){
        attributes.remove(att);
    }

}
