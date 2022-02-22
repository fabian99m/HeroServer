package com.server.serverAPI.Infraestructura.Persistencia.Repository.Purchase;


import com.server.serverAPI.Domain.Modelo.DTO.ListPurchases;
import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Domain.Modelo.Purchase;
import com.server.serverAPI.Domain.Repositorio.PurchaseRepository;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.ListPurchaseBuilder;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.ProductDTOMapper;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.PurchaseMapper;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection.ProductDto;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection.PurchaseListDTO;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.PurchaseDao;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.PurchaseEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequiredArgsConstructor
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final PurchaseDao purchaseDao;
    private final PurchaseMapper purchaseMapper;
    private final ListPurchaseBuilder listPurchaseBuilder;
    private final ProductDTOMapper productDTOMapper;


    static Logger logger = LoggerFactory.getLogger(PurchaseRepositoryImpl.class);

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = purchaseMapper.toPurchaseEntity(purchase);
        var a = purchaseDao.save(purchaseEntity);
        logger.info("Compra de BD: "+a);
        return purchaseMapper.toPurchase(a);
    }

    @Override
    public List<ListPurchases> getAllPurchases() {
        List<PurchaseListDTO> allPurchases = purchaseDao.getAllPurchases();
        return listPurchaseBuilder.toListPurchasesList(allPurchases);
    }

    @Override
    public List<ListPurchases> getAllPurchasesByHeroId(Long idHero) {
        List<PurchaseListDTO> allPurchases = purchaseDao.getAllPurchasesByHeroId(idHero);
        return listPurchaseBuilder.toListPurchasesList(allPurchases);
    }

    @Override
    public Product getBestSellProduct() {
        ProductDto productDto = purchaseDao.getBestSellProduct();
        return productDTOMapper.toProduct(productDto);
    }


}
