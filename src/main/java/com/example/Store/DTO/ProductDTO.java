package com.example.Store.DTO;

import com.example.Store.Models.Attribute;

import java.util.List;

public class ProductDTO {
    public record AttributeResponse(
            Long id,
            String key,
            String value
    ){}

    public record CreateRequest(
            String name,
            String description,
            Double price,
            Long producerId
    ){}
    public record UpdateRequest(
            Integer id,
            String name,
            String description,
            Double price
    ){}

    public record Response(
            Long id,
            String name,
            String description,
            Double price,
            Long producerId,
            String producerName,
            List<AttributeDTO.Response> attributes

    ){}
}
