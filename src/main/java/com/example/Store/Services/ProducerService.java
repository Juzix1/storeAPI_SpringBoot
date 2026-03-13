package com.example.Store.Services;

import com.example.Store.DTO.ProducerDTO;
import com.example.Store.Models.Producer;
import com.example.Store.Repository.ProducerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final ProducerRepo repo;
    private final ProductService productService;


    public List<ProducerDTO.Response> getAllProducers() {
       List<ProducerDTO.Response> responses = new ArrayList<>();
        for(Producer producer : repo.findAll()) {
           responses.add(getProducerResponse(producer));
       }
        return responses;
    }

    public ProducerDTO.Response getProducerById(int id){
        Producer producer = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("producer not found "+id));
        return getProducerResponse(producer);
    }

    public Producer addProducer(ProducerDTO.CreateRequest producerRequest){
        Producer newProducer = new Producer(
                producerRequest.name());
        repo.save(newProducer);
        return newProducer;
    }
    public void deleteProducerById(int id) {
        repo.deleteById(id);
    }
    public void updateProducer(Producer producer, int id) {
        Producer prod = repo.findById(id).orElse(null);
        if (prod != null) {
            prod = producer;
        }
        repo.save(prod);
    }

    public ProducerDTO.Response getProducerResponse(Producer producer) {
        return new ProducerDTO.Response(
                producer.getId(),
                producer.getName()
        );
    }
}
