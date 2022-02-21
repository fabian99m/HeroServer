package com.server.serverAPI.Infraestructura.Endpoints.Purchase;


import com.server.serverAPI.Aplicacion.Service.Purchase.SavePurchaseService;
import com.server.serverAPI.Domain.Modelo.Purchase;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase")
public class SavePurchaseEndpoint {

    @Autowired
    private SavePurchaseService savePurchaseService;

    @PostMapping("/save")
    public ResponseEntity<Respuesta<Purchase>> saveHero( @RequestBody Purchase purchase) {
        return savePurchaseService.savePurchase(purchase);
    }

}
