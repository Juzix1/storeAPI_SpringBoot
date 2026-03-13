package com.example.Store.Repository;

import com.example.Store.Models.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepo extends JpaRepository<Producer, Integer> {

}
