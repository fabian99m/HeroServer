package com.server.serverAPI.Infraestructura.Persistencia.Repository.Product;

import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Domain.Repositorio.ProductRepository;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.ProductMapper;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.ProductDao;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.ProductEntity;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductDao productDao;
    private final ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productDao.save(productMapper.toProductEntity(product));
        return productMapper.toProduct(productEntity);
    }
}
