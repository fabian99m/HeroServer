package com.server.serverAPI.Domain.Modelo;


import lombok.Data;

@Data
public class Purchase {

    private Long purchaseId;

    private Product product;

    private Hero client;

    private int quantity;

}
