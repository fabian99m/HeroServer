package com.server.serverAPI.Aplicacion.Service;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class GetHeroByNameService {

    private final HeroRepository heroRepository;

    public ResponseEntity<Respuesta<List<Hero>>> getHerosByName(String name) {
        List<Hero> heroes = heroRepository.findByNameEquals(name);
        return heroes.isEmpty()
                ? new  ResponseEntity<>(new Respuesta<>("No se encontraron héroes con el nombre "+name), HttpStatus.OK)
                : new ResponseEntity<>(new Respuesta<>("Héroes encontrados con éxito!", heroes), HttpStatus.OK);
    }

}
