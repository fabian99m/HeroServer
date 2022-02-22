package com.server.serverAPI.Aplicacion.Service.Purchase;

import com.server.serverAPI.Domain.Modelo.DTO.ListPurchases;
import com.server.serverAPI.Domain.Repositorio.PurchaseRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class ListAllPurchasesService {

    private final PurchaseRepository purchaseRepository;

    static Logger logger = LoggerFactory.getLogger(ListAllPurchasesService.class);

    public ResponseEntity<Respuesta<List<ListPurchases>>> ListAllPurchases() {

        List<ListPurchases> listPurchases = purchaseRepository.getAllPurchases();

        return listPurchases.isEmpty()
                ? new  ResponseEntity<>(new Respuesta<>("No se encontraron compras!", listPurchases), HttpStatus.OK)
                : new ResponseEntity<>(new Respuesta<>("Compras encontradas con éxito!", listPurchases), HttpStatus.OK);
    }

}
