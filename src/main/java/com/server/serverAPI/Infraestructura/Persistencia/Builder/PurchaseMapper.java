package com.server.serverAPI.Infraestructura.Persistencia.Builder;

import com.server.serverAPI.Domain.Modelo.Purchase;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HeroMapper.class, ProductMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping( target = "purchaseId", ignore = true)
    })
    PurchaseEntity toPurchaseEntity(Purchase purchase);

    @InheritInverseConfiguration
    Purchase toPurchase(PurchaseEntity purchaseEntity);

    List<Purchase> toPurchaseList(List<PurchaseEntity> purchaseEntityList);

}
