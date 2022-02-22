package com.server.serverAPI.Infraestructura.Endpoints.Purchase;


import com.server.serverAPI.Aplicacion.Service.Purchase.ListPurchasesByIdHeroService;
import com.server.serverAPI.Domain.Modelo.DTO.ListPurchases;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("purchase")
public class ListPurchasesByIdHeroEndpoint {

    @Autowired
    private ListPurchasesByIdHeroService  listPurchasesByIdHeroService;

    @GetMapping(value = "/list", params = "idHero")
    public ResponseEntity<Respuesta<List<ListPurchases>>> saveHero(@RequestParam Long idHero) {
        return listPurchasesByIdHeroService.ListPurchasesByIdHero(idHero);
    }

}
