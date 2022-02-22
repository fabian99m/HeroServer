package com.server.serverAPI.Domain.Repositorio;

import com.server.serverAPI.Domain.Modelo.DTO.ListPurchases;
import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Domain.Modelo.Purchase;

import java.util.List;

public interface PurchaseRepository {

    Purchase save(Purchase purchase);

    List<ListPurchases> getAllPurchases();

    List<ListPurchases> getAllPurchasesByHeroId(Long idHero);

    Product getBestSellProduct();
}
