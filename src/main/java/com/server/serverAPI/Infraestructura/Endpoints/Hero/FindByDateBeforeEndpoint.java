package com.server.serverAPI.Infraestructura.Endpoints.Hero;

import com.server.serverAPI.Aplicacion.Service.Hero.FindByDateBeforeService;
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
@RequestMapping("hero")
public class FindByDateBeforeEndpoint {

    @Autowired
    private FindByDateBeforeService findByDateBeforeService;

    @GetMapping(value = "/listbefore", params = "fecha", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Respuesta<List<Hero>>> getheros(@RequestParam String fecha) {
        return findByDateBeforeService.findByDateBefore(fecha);
    }


}
