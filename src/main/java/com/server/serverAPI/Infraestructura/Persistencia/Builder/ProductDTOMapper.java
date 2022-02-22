package com.server.serverAPI.Infraestructura.Persistencia.Builder;

import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {
    Product toProduct(ProductDto productDto);
}
