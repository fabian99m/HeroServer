package com.server.serverAPI.Domain.Modelo.DTO;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ListPurchases {

    private String heroname;
    private Long purchaseid;
    private int quantity;
    private String productname;

}
