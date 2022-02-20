package com.server.serverAPI.Aplicacion.Service.Hero;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class GetHeroByNameService {

    private final HeroRepository heroRepository;

    static Logger logger = LoggerFactory.getLogger(GetHeroByNameService.class);

    public ResponseEntity<Respuesta<List<Hero>>> getHerosByName(String name) {
        logger.info("Hero.name recibido: "+name);
        List<Hero> heroes = heroRepository.findByNameEquals(name);
        return heroes.isEmpty()
                ? new  ResponseEntity<>(new Respuesta<>("No se encontraron héroes con el nombre "+name), HttpStatus.OK)
                : new ResponseEntity<>(new Respuesta<>("Héroes encontrados con éxito!", heroes), HttpStatus.OK);
    }

}
