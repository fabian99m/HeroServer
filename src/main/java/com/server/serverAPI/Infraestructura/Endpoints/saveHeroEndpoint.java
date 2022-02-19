package com.server.serverAPI.Infraestructura.Endpoints;


import com.server.serverAPI.Aplicacion.Service.SaveHeroService;
import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hero")
public class saveHeroEndpoint {

    @Autowired
    private SaveHeroService saveHeroService;

    @PostMapping("/save")
    public ResponseEntity<Respuesta<Hero>> saveHero(@RequestBody Hero hero) {
        return saveHeroService.saveHero(hero);
    }
}
