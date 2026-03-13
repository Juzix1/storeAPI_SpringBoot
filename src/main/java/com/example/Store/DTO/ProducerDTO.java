package com.example.Store.DTO;

public class ProducerDTO {
    public record Response(
            Long id,
            String name
    ){}
    public record CreateRequest(
            String name
    ){}

    public record UpdateRequest(
            String name,
            String description
    ){}
}
