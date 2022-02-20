package com.server.serverAPI.Infraestructura.Persistencia.Repository.Purchase;


import com.server.serverAPI.Domain.Modelo.Purchase;
import com.server.serverAPI.Domain.Repositorio.PurchaseRepository;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.PurchaseMapper;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.PurchaseDao;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.PurchaseEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final PurchaseDao purchaseDao;
    private final PurchaseMapper purchaseMapper;

    static Logger logger = LoggerFactory.getLogger(PurchaseRepositoryImpl.class);

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = purchaseMapper.toPurchaseEntity(purchase);
        var a = purchaseDao.save(purchaseEntity);
        logger.info("Compra de BD: "+a);
        return purchaseMapper.toPurchase(a);
    }

}
