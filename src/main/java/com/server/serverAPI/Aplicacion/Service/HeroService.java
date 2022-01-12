package com.server.serverAPI.Aplicacion.Service;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Error.HeroNoEncontrado;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

import java.util.Date;
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

        //logger.info(heroRepository.findByDateBefore("01/01/2022").toString());

       // String a = HeroServiceUtil.convertiFecha(heroBd.getCreatedDate());
       // logger.info(a);

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

    public ResponseEntity<Respuesta<List<Hero>>> findByDateBefore(String fecha) {
        Date date = HeroServiceUtil.convertirFecha(fecha);
        if(date == null) {
            return new ResponseEntity<>(new Respuesta<>("Formato de fecha incorrecto!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Hero> heroList = heroRepository.findByDateBefore(date);
        return heroList.isEmpty()
            ? new ResponseEntity<>(new Respuesta<>("No se encontraron héroes con fecha de creación antes de "+fecha), HttpStatus.OK)
            : new ResponseEntity<>(new Respuesta<>("Héroes encontrados con éxito!",heroList), HttpStatus.OK);
    }

}
