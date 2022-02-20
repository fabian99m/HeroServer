package com.server.serverAPI.Infraestructura.Endpoints.Hero;

import com.server.serverAPI.Aplicacion.Service.Hero.GetHeroByNameService;
import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "hero")
public class getHeroByNameEndpoint {

    @Autowired
    private GetHeroByNameService getHeroByNameService;

    @GetMapping(value = "/list", params = "nombre", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Respuesta<List<Hero>>> getheros(@RequestParam String nombre) {
       return getHeroByNameService.getHerosByName(nombre);
    }

}
