package com.server.serverAPI.Infraestructura.Endpoints;

import com.server.serverAPI.Aplicacion.Service.UpdateNamaService;
import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hero")
public class UpdateNameEndpoint {

    @Autowired
    UpdateNamaService updateNamaService;

    @PatchMapping()
    public ResponseEntity<Respuesta<Hero>> updateName(@RequestBody Hero hero){
        return updateNamaService.updateName(hero);
    }
}
