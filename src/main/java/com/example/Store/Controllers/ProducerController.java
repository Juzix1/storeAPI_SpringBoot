package com.example.Store.Controllers;

import com.example.Store.DTO.ProducerDTO;
import com.example.Store.Models.Producer;
import com.example.Store.Services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService service;

    @RequestMapping("/producers")
    public List<ProducerDTO.Response> getAllProducers(){
        return service.getAllProducers();
    }

    @RequestMapping("/producers/{id}")
    public ProducerDTO.Response findById(@PathVariable Integer id){
        return service.getProducerById(id);
    }

    @PostMapping("/producer")
    public Producer addProducer(@RequestBody ProducerDTO.CreateRequest producer){
        return service.addProducer(producer);
    }
    @DeleteMapping("/producer/{id}")
    public void deleteProducer(@PathVariable Integer id){
        service.deleteProducerById(id);
    }

}
