package com.server.serverAPI.Infraestructura.Persistencia.Repository.Purchase;


import com.server.serverAPI.Domain.Modelo.DTO.ListPurchases;
import com.server.serverAPI.Domain.Modelo.Purchase;
import com.server.serverAPI.Domain.Repositorio.PurchaseRepository;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.ListPurchaseBuilder;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.PurchaseMapper;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection.PurchaseListDTO;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.PurchaseDao;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.PurchaseEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final PurchaseDao purchaseDao;
    private final PurchaseMapper purchaseMapper;

    private final ListPurchaseBuilder listPurchaseBuilder;


    static Logger logger = LoggerFactory.getLogger(PurchaseRepositoryImpl.class);

    @Override
    public Purchase save(Purchase purchase) {

        this.test();

        PurchaseEntity purchaseEntity = purchaseMapper.toPurchaseEntity(purchase);
        var a = purchaseDao.save(purchaseEntity);
        logger.info("Compra de BD: "+a);
        return purchaseMapper.toPurchase(a);
    }

    private void test() {
        List<PurchaseListDTO> allPurchases = purchaseDao.getAllPurchases();

        var a = listPurchaseBuilder.toListPurchasesList(allPurchases);
       // var a = mapearCompras(allPurchases);
        logger.info(a.toString());
    }

    private List<ListPurchases> mapearCompras(List<PurchaseListDTO> purchaseListDTO) {
        List<ListPurchases> listPurchasesList = new ArrayList<>();
        for(PurchaseListDTO purchase : purchaseListDTO) {
            ListPurchases listPurchases = ListPurchases.builder()
                    .heroname(purchase.getHeroName())
                    .purchaseid(purchase.getPurchaseId().longValue())
                    .quantity(purchase.getQuantity())
                    .productname(purchase.getProductName())
                    .build();
            listPurchasesList.add(listPurchases);
        }
        return listPurchasesList;
    }

}
