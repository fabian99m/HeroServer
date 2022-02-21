package com.server.serverAPI.Domain.Modelo;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Product {

    private long id;

    private String name;

    @Min(0)
    private int stock;

}
