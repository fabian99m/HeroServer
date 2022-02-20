package com.server.serverAPI.Aplicacion.Service.Purchase;


import com.server.serverAPI.Aplicacion.Service.Hero.HeroServiceUtil;
import com.server.serverAPI.Aplicacion.Service.Product.ProductServiceUtil;
import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Domain.Modelo.Purchase;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Domain.Repositorio.ProductRepository;
import com.server.serverAPI.Domain.Repositorio.PurchaseRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.PurchasesaveErr;
import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.PurchasesaveSucc;

@RequiredArgsConstructor
public class SavePurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final HeroRepository heroRepository;
    private final ProductRepository productRepository;

    static Logger logger = LoggerFactory.getLogger(SavePurchaseService.class);

    public ResponseEntity<Respuesta<Purchase>> savePurchase(Purchase purchase) {

        Hero hero = HeroServiceUtil.findHeroByid(purchase.getClient().getCodigo(), heroRepository);
        Product product = ProductServiceUtil.findProductById(purchase.getProduct().getId(), productRepository);

        purchase.setClient(hero);
        purchase.setProduct(product);

        ProductServiceUtil.availablePurchase(purchase.getQuantity(), product.getStock());

        logger.info("Compra recibida: "+purchase);
        Purchase purchaseBd = purchaseRepository.save(purchase);

        if (purchaseBd == null) {
            return new ResponseEntity<>(new Respuesta<>(PurchasesaveErr), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        ProductServiceUtil.updateStock(productRepository, product, purchase.getQuantity());

        return new ResponseEntity<>(new Respuesta<>(PurchasesaveSucc, purchaseBd), HttpStatus.OK);

    }
}
