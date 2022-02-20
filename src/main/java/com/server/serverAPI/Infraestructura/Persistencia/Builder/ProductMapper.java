package com.server.serverAPI.Infraestructura.Persistencia.Builder;

import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toProductEntity(Product product);

    @InheritInverseConfiguration
    Product toProduct(ProductEntity productEntity);

    List<Product> toProductList(List<ProductEntity> productEntityList);

}
