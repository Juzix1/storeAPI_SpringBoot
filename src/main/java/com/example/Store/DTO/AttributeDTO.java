package com.example.Store.DTO;

public class AttributeDTO {
    public record Response(
        String name,
        String value
    ){}

    public record CreateRequest(
        String name,
        String value,
        Long productId
    ){}

    public record UpdateRequest(
        int id,
        String name,
        String value,
        Long productId
    ){}
}
