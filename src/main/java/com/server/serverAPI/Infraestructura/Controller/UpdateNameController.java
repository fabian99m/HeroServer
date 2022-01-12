package com.server.serverAPI.Infraestructura.Controller;

import com.server.serverAPI.Aplicacion.Service.HeroService;
import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hero")
public class UpdateNameController {

    @Autowired
    HeroService heroService;

    @PatchMapping()
    public ResponseEntity<Respuesta<Hero>> updateName(@RequestBody Hero hero){
        return heroService.updateName(hero);
    }
}
