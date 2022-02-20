package com.server.serverAPI.Infraestructura.Endpoints.Hero;

import com.server.serverAPI.Aplicacion.Service.Hero.DeleteHeroService;
import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hero")
public class deleteHeroEndpoint {
    
    @Autowired
    private DeleteHeroService deleteHeroService;

    @DeleteMapping( params = "codigo")
    public ResponseEntity<Respuesta<Hero>> deleleHero(@RequestParam Long codigo){
        return deleteHeroService.deleteHeroById(codigo);
    }

}
