package com.server.serverAPI.Infraestructura.Persistencia.DAO;

import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection.ProductDto;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.InterfaceProjection.PurchaseListDTO;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseDao extends JpaRepository<PurchaseEntity, Integer> {

    @Query(value = "SELECT hero.name as heroName, purchase.purchase_id as purchaseId, purchase.quantity as Quantity, product.name as productName " +
            "FROM purchase " +
            "INNER JOIN hero ON hero.id = purchase.hero_id " +
            "INNER JOIN product ON product.id = purchase.product_id", nativeQuery = true)
    List<PurchaseListDTO> getAllPurchases();

    @Query(value = "SELECT hero.name as heroName, purchase.purchase_id as purchaseId, purchase.quantity as Quantity, product.name as productName " +
            "FROM purchase " +
            "INNER JOIN hero ON hero.id = purchase.hero_id " +
            "INNER JOIN product ON product.id = purchase.product_id " +
            "WHERE hero.id = :idHero", nativeQuery = true)
    List<PurchaseListDTO> getAllPurchasesByHeroId(@Param("idHero") Long idHero);

    @Query(value = "SELECT product.id as id, product.name as name, product.stock as stock " +
            "FROM purchase " +
            "INNER JOIN product ON product.id = purchase.product_id " +
            "GROUP BY product.id, product.name, product.stock " +
            "ORDER BY COUNT(product_id) DESC " +
            "LIMIT 1", nativeQuery = true)
    ProductDto getBestSellProduct();

}
