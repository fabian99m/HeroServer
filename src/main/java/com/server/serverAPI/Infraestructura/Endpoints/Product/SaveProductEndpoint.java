package com.server.serverAPI.Infraestructura.Endpoints.Product;

import com.server.serverAPI.Aplicacion.Service.Product.SaveProductService;
import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("product")
public class SaveProductEndpoint {
    @Autowired
    private SaveProductService saveProductService;

    @PostMapping("/save")
    public ResponseEntity<Respuesta<Product>> saveHero(@RequestBody Product product) {
        return saveProductService.saveHero(product);
    }

}
