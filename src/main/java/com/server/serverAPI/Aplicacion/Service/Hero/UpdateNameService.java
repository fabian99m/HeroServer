package com.server.serverAPI.Aplicacion.Service.Hero;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Error.HeroNoEncontrado;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class UpdateNameService {

    private final HeroRepository heroRepository;

    static Logger logger = LoggerFactory.getLogger(UpdateNameService.class);

    public ResponseEntity<Respuesta<Hero>> updateName(Hero hero) {
        logger.info("Heroe recibido: "+hero);
        if(!heroRepository.existsById(hero.getCodigo())){
            throw new HeroNoEncontrado("Hero no existente!");
        }
        heroRepository.save(hero);
        return new ResponseEntity<>(new Respuesta<>("Héroe actualizado con éxito!", hero), HttpStatus.OK);
    }

}
