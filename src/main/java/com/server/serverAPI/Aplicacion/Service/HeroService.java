package com.server.serverAPI.Aplicacion.Service;

import com.server.serverAPI.Dominio.Modelo.Hero;
import com.server.serverAPI.Dominio.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Error.HeroNoEncontrado;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.server.serverAPI.Aplicacion.Mensajes.ConstMensajes.*;

@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;

    Logger logger = LoggerFactory.getLogger(HeroService.class);

    public ResponseEntity<Respuesta<Hero>> saveHero(Hero hero) {
        Hero heroBd = heroRepository.save(hero);
        if (heroBd == null) {
            return new ResponseEntity<>(new Respuesta<>(HerosaveErr), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Respuesta<>(HerosaveSucc, heroBd), HttpStatus.OK);
    }

    public ResponseEntity<Respuesta<List<Hero>>> getHeros() {

       logger.info(heroRepository.findByName("jose").toString());

        List<Hero> heroes = heroRepository.getAll();
        return heroes.isEmpty()
                ? new  ResponseEntity<>(new Respuesta<>("No se encontraron héroes!"), HttpStatus.OK)
                : new ResponseEntity<>(new Respuesta<>("Héroes encontrados con éxito!", heroes), HttpStatus.OK);
    }

    public ResponseEntity<Respuesta<List<Hero>>> getHerosByName(String name) {
        List<Hero> heroes = heroRepository.findByNameEquals(name);
        return heroes.isEmpty()
                ? new  ResponseEntity<>(new Respuesta<>("No se encontraron héroes con el nombre "+name), HttpStatus.OK)
                : new ResponseEntity<>(new Respuesta<>("Héroes encontrados con éxito!", heroes), HttpStatus.OK);
    }

    public ResponseEntity<Respuesta<Hero>> updateName(Hero hero) {
        if(!heroRepository.existsById(hero.getCodigo())){
            throw new HeroNoEncontrado("Hero no existente!");
        }
        heroRepository.save(hero);
        return new ResponseEntity<>(new Respuesta<>("Héroe actualizado con éxito!", hero), HttpStatus.OK);
    }

    public ResponseEntity<Respuesta<Hero>> deleteHeroById(Integer id){
      Hero heroBd = HeroServiceUtil.findHeroByid(id, heroRepository);
      heroRepository.deleteHero(id);
      return new ResponseEntity<>(new Respuesta<>("Héroe eliminado con éxito!", heroBd), HttpStatus.OK);
    }

    public Respuesta<Hero> findHeroById(Integer id) {
        Hero hero = HeroServiceUtil.findHeroByid(id, heroRepository);
        return new Respuesta<>(hero);
    }

}
