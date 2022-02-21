package com.server.serverAPI.Domain.Modelo;


import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Purchase {

    private Long purchaseId;

    private Product product;

    private Hero client;

    @Min(value = 1, message = "requerido")
    private int quantity;

}
