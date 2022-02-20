package com.server.serverAPI.Aplicacion.Service.Hero;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class DeleteHeroService  {

   private final HeroRepository heroRepository;

    public ResponseEntity<Respuesta<Hero>> deleteHeroById(Integer id){

        Hero heroBd = HeroServiceUtil.findHeroByid(id, heroRepository);
        heroRepository.deleteHero(id);
        return new ResponseEntity<>(new Respuesta<>("Héroe eliminado con éxito!", heroBd), HttpStatus.OK);
    }
}
