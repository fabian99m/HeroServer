package com.server.serverAPI.Infraestructura.Persistencia.DAO;


import com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection.PurchaseListDTO;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseDao extends JpaRepository<PurchaseEntity, Integer> {


    @Query(value = "SELECT hero.name as heroName, purchase.purchase_id as purchaseId, purchase.quantity as Quantity, product.name as productName " +
            "FROM purchase " +
            "INNER JOIN hero ON hero.id = purchase.hero_id " +
            "INNER JOIN product ON product.id = product_id", nativeQuery = true)
    List<PurchaseListDTO> getAllPurchases();



}
