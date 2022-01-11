package com.server.serverAPI.Infraestructura.Controller;

import com.server.serverAPI.Aplicacion.Service.HeroService;
import com.server.serverAPI.Dominio.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hero")
public class deleteHeroController {
    
    @Autowired
    private HeroService heroService;

    @DeleteMapping( params = "codigo")
    public ResponseEntity<Respuesta<Hero>> deleleHero(@RequestParam Integer codigo){
        return heroService.deleteHeroById(codigo);
    }

}
