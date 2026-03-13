package com.example.Store.Services;

import com.example.Store.DTO.AttributeDTO;
import com.example.Store.Models.Attribute;
import com.example.Store.Models.Product;
import com.example.Store.Repository.AttributeRepo;
import com.example.Store.Repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttributeService {
    private final AttributeRepo attributeRepo;
    private final ProductRepo productRepo;

    public List<AttributeDTO.Response> getAllAttributes(){
        List<AttributeDTO.Response> list = new ArrayList<>();
        for(Attribute attribute : attributeRepo.findAll()){
            list.add(getAttributeResponse(attribute));
        }
        return list;
    }

    public AttributeDTO.Response getAttributeById(int id){
        Attribute attribute = attributeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Attribute not found"));
        return getAttributeResponse(attribute);
    }

    public AttributeDTO.Response addAttribute(AttributeDTO.CreateRequest request){
        Product product = productRepo.findById(Math.toIntExact(request.productId()))
                .orElseThrow(() -> new RuntimeException("Product not found: " + request.productId()));
        if(attributeRepo.existsByNameAndProductId(request.name(), request.productId())){
            throw new RuntimeException("Attribute "+request.name()+" already exists for product with Id" + request.productId());
        }

        Attribute attribute = new Attribute(request.name(), request.value(), product);
        Attribute saved = attributeRepo.save(attribute);
        return getAttributeResponse(saved);
    }
    public void deleteById(int id){
        attributeRepo.deleteById(id);
    }

    public AttributeDTO.Response updateAttribute(AttributeDTO.UpdateRequest attributeDTO){
        Attribute attribute = attributeRepo.findById(attributeDTO.id())
                .orElseThrow(() -> new RuntimeException("Attribute not found"));

        attribute.setName(attributeDTO.name());
        attribute.setAttributeValue(attributeDTO.value());
        attributeRepo.save(attribute);
        return getAttributeResponse(attribute);
    }




    public AttributeDTO.Response getAttributeResponse(Attribute attribute){
        return new AttributeDTO.Response(
                attribute.getName(),
                attribute.getAttributeValue()
        );
    }

}
