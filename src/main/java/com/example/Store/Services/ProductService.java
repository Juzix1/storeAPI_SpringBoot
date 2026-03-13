package com.example.Store.Services;

import com.example.Store.DTO.AttributeDTO;
import com.example.Store.DTO.ProductDTO;
import com.example.Store.Models.Producer;
import com.example.Store.Models.Product;
import com.example.Store.Repository.ProducerRepo;
import com.example.Store.Repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService     {

    private final ProductRepo repo;
    private final ProducerRepo producerRepo;

    public ProductService(ProductRepo repo, ProducerRepo producerRepo) {
        this.repo = repo;
        this.producerRepo = producerRepo;
    }

    @Transactional
    public List<ProductDTO.Response> getProducts(String name, Long producerId, Double minPrice, Double maxPrice) {
        List<Product> products;
        if (producerId != null && name != null) {
            products = repo.findAllByProducerIdAndNameContainingIgnoreCase(producerId, name);
        } else if (producerId != null) {
            products = repo.findAllByProducerId(producerId);
        } else if (name != null) {
            products = repo.findAllByNameContainingIgnoreCase(name);
        } else if (minPrice != null && maxPrice != null) {
            products = repo.findAllByPriceBetween(minPrice, maxPrice);
        }else {
            products = repo.findAll();
        }
        return products.stream()
                .map(this::getProductResponse)
                .toList();
    }

    public ProductDTO.Response getProductById(long id){
        Product product =  repo.findById((int) id)
                .orElseThrow(() -> new RuntimeException("product not found "+id));

        return getProductResponse(product);
    }

    public ProductDTO.Response addProduct(ProductDTO.CreateRequest createRequest){
        Producer producer = producerRepo.findById((int) createRequest.producerId().longValue())
                .orElseThrow(() -> new RuntimeException("Producer not found: " + createRequest.producerId()));
        Product newProduct = new Product(
                    createRequest.name(),
                    createRequest.description(),
                    createRequest.price(),
                    producer
            );
            repo.save(newProduct);
            return getProductResponse(newProduct);
    }
    public ProductDTO.Response updateProduct(ProductDTO.UpdateRequest prod){
        Product product =  repo.findById(prod.id()).orElseThrow(() -> new RuntimeException("product not found "+prod.id()));
        product.setName(prod.name());
        product.setDescription(prod.description());
        product.setPrice(prod.price());
        repo.save(product);
        return getProductResponse(product);
    }
    public void deleteProduct(int id){
        repo.deleteById(id);
    }

    public ProductDTO.Response getProductResponse(Product prod){

        List<AttributeDTO.Response> attributes = new ArrayList<>(prod.getAttributes())
                .stream()
                .map(a -> new AttributeDTO.Response(a.getName(), a.getAttributeValue()))
                .toList();

        return new ProductDTO.Response(
                prod.getId(),
                prod.getName(),
                prod.getDescription(),
                prod.getPrice(),
                prod.getProducer().getId(),
                prod.getProducer().getName(),
                attributes
        );
    }

}
