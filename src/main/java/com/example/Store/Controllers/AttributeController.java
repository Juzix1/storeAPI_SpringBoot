package com.example.Store.Controllers;

import com.example.Store.DTO.AttributeDTO;
import com.example.Store.Models.Attribute;
import com.example.Store.Services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttributeController {
    @Autowired
    private AttributeService service;

    @RequestMapping("/attributes")
    public List<AttributeDTO.Response> getAllAttributes(){
        return service.getAllAttributes();
    }

    @RequestMapping("/attributes/{id}")
    public AttributeDTO.Response getAttributeById(@PathVariable int id){
        return service.getAttributeById(id);
    }
    @PostMapping("/attribute")
    public AttributeDTO.Response addNewAttribute(@RequestBody AttributeDTO.CreateRequest request){
        return service.addAttribute(request);
    }
    @DeleteMapping("/attribute/{id}")
    public void deleteAttribute(@PathVariable int id){
        service.deleteById(id);
    }
    @PutMapping("/attribute")
    public AttributeDTO.Response updateAttribute(@RequestBody AttributeDTO.UpdateRequest request){
       return service.updateAttribute(request);
    }

}
