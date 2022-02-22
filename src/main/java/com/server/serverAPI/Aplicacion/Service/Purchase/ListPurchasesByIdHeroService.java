package com.server.serverAPI.Aplicacion.Service.Purchase;


import com.server.serverAPI.Aplicacion.Service.Hero.HeroServiceUtil;
import com.server.serverAPI.Domain.Modelo.DTO.ListPurchases;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Domain.Repositorio.PurchaseRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class ListPurchasesByIdHeroService {

    private final PurchaseRepository purchaseRepository;
    private final HeroRepository heroRepository;

    static Logger logger = LoggerFactory.getLogger(ListPurchasesByIdHeroService.class);

    public ResponseEntity<Respuesta<List<ListPurchases>>> ListPurchasesByIdHero(Long idHero) {

        HeroServiceUtil.existsById(idHero, heroRepository);

        logger.info("idHero recibida: "+idHero);
        List<ListPurchases> listPurchases = purchaseRepository.getAllPurchasesByHeroId(idHero);

        return listPurchases.isEmpty()
                ? new  ResponseEntity<>(new Respuesta<>("No se encontraron compras para el Id!", listPurchases), HttpStatus.OK)
                : new ResponseEntity<>(new Respuesta<>("Compras encontradas con éxito!", listPurchases), HttpStatus.OK);
    }

}
