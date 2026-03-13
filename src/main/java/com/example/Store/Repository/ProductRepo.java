package com.example.Store.Repository;

import com.example.Store.Models.Producer;
import com.example.Store.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findAllByProducerId(long producerId);
    List<Product> findAllByNameContainingIgnoreCase(String name);
    List<Product> findAllByPriceBetween(double min, double max);
    List<Product> findAllByProducerIdAndNameContainingIgnoreCase(long producerId, String name);
}