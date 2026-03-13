package com.example.Store.Repository;

import com.example.Store.Models.Attribute;
import com.example.Store.Models.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Attr;

import java.util.List;

@Repository
public interface AttributeRepo extends JpaRepository<Attribute, Integer> {
    List<Attribute> findAllByProductId(long productId);
    boolean existsByNameAndProductId(String name, long productId);
}
