package com.server.serverAPI.Aplicacion.Service.Product;


import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Domain.Repositorio.ProductRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.ProductaveErr;
import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.ProductsaveSucc;

@RequiredArgsConstructor
public class SaveProductService {

    private final ProductRepository productRepository;

    static Logger logger = LoggerFactory.getLogger(SaveProductService.class);

    public ResponseEntity<Respuesta<Product>> saveHero(Product product) {
        logger.info("Producto recibido: "+product);
        Product productBd = productRepository.save(product);
        if (productBd == null) {
            return new ResponseEntity<>(new Respuesta<>(ProductaveErr), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Respuesta<>(ProductsaveSucc, productBd), HttpStatus.OK);
    }

}
