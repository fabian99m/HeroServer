package com.server.serverAPI.Domain.Repositorio;

import com.server.serverAPI.Domain.Modelo.Product;

public interface ProductRepository {

    Product save(Product product);

    Boolean existsById(long id);

    Product findById(long id);

}
