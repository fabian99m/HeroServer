package com.server.serverAPI.Infraestructura.Endpoints;

import com.server.serverAPI.Aplicacion.Service.GetHerosService;
import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "hero")
public class getHerosEndpoint {

    @Autowired
    private GetHerosService getHerosService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Respuesta<List<Hero>>> getheros() {
       return getHerosService.getHeros();
    }

}