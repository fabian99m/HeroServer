package com.server.serverAPI.Infraestructura.Persistencia.Builder;


import com.server.serverAPI.Domain.Modelo.DTO.ListPurchases;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection.PurchaseListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.math.BigInteger;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ListPurchaseBuilder {

    @Mappings({
            @Mapping(source = "heroName",  target = "heroname"),
            @Mapping(source = "purchaseId",  target = "purchaseid", qualifiedByName = "map"),
            @Mapping( source = "quantity", target = "quantity"),
            @Mapping( source = "productName",target = "productname"),
    })
    ListPurchases toListPurchases(PurchaseListDTO purchaseListDTO);

    @Named("map")
     static long map(BigInteger bigInteger) {
        return bigInteger.longValue();
    }

    List<ListPurchases> toListPurchasesList(List<PurchaseListDTO> purchaseListDTO);
}
