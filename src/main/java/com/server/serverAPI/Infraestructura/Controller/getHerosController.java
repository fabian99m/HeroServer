package com.server.serverAPI.Infraestructura.Controller;

import com.server.serverAPI.Aplicacion.Service.HeroService;
import com.server.serverAPI.Dominio.Modelo.Hero;
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
public class getHerosController {

    @Autowired
    private HeroService heroService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Respuesta<List<Hero>>> getheros() {
       return heroService.getHeros();
    }

}