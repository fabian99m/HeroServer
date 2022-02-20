package com.server.serverAPI.Aplicacion.Service.Hero;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.HerosaveErr;
import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.HerosaveSucc;

@RequiredArgsConstructor
public class SaveHeroService {

    private final HeroRepository heroRepository;

    static Logger logger = LoggerFactory.getLogger(SaveHeroService.class);

    public ResponseEntity<Respuesta<Hero>> saveHero(Hero hero) {
        logger.info("Heroe recibido: "+hero);
        Hero heroBd = heroRepository.save(hero);
        if (heroBd == null) {
            return new ResponseEntity<>(new Respuesta<>(HerosaveErr), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Respuesta<>(HerosaveSucc, heroBd), HttpStatus.OK);
    }

}
