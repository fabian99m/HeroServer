package com.server.serverAPI.Domain.Modelo;


import lombok.Data;

@Data
public class Purchase {

    private int purchaseId;

    private Product product;

    private int clientId;

    private int quantity;

}
