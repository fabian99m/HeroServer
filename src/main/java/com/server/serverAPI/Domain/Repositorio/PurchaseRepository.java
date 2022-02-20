package com.server.serverAPI.Domain.Repositorio;

import com.server.serverAPI.Domain.Modelo.Purchase;

public interface PurchaseRepository {

    Purchase save(Purchase purchase);
}
