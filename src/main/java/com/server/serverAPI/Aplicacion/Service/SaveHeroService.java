package com.server.serverAPI.Aplicacion.Service;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.HerosaveErr;
import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.HerosaveSucc;

@RequiredArgsConstructor
public class SaveHeroService {

    private final HeroRepository heroRepository;

    public ResponseEntity<Respuesta<Hero>> saveHero(Hero hero) {
        Hero heroBd = heroRepository.save(hero);
        if (heroBd == null) {
            return new ResponseEntity<>(new Respuesta<>(HerosaveErr), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Respuesta<>(HerosaveSucc, heroBd), HttpStatus.OK);
    }

}
