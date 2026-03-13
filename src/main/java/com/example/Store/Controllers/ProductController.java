package com.example.Store.Controllers;

import com.example.Store.DTO.ProductDTO;
import com.example.Store.Models.Product;
import com.example.Store.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<ProductDTO.Response> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long producerId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return service.getProducts(name,producerId,minPrice,maxPrice);
    }

    @RequestMapping("/products/{id}")
    public ProductDTO.Response getProductById(@PathVariable long id){
        return service.getProductById(id);
    }


    @PostMapping("/product")
    public ProductDTO.Response addProduct(@RequestBody ProductDTO.CreateRequest createRequest){
        return service.addProduct(createRequest);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
    }

    @PutMapping("/product")
    public ProductDTO.Response updateProduct(@RequestBody ProductDTO.UpdateRequest request){
        return service.updateProduct(request);
    }
}
