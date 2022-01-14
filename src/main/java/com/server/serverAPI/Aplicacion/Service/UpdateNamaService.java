package com.server.serverAPI.Aplicacion.Service;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Error.HeroNoEncontrado;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class UpdateNamaService {

    private final HeroRepository heroRepository;

    public ResponseEntity<Respuesta<Hero>> updateName(Hero hero) {
        if(!heroRepository.existsById(hero.getCodigo())){
            throw new HeroNoEncontrado("Hero no existente!");
        }
        heroRepository.save(hero);
        return new ResponseEntity<>(new Respuesta<>("Héroe actualizado con éxito!", hero), HttpStatus.OK);
    }

}
