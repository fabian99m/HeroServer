package com.server.serverAPI.Aplicacion.Service.Hero;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RequiredArgsConstructor
public class FindByIdService {

    private final HeroRepository heroRepository;

    static Logger logger = LoggerFactory.getLogger(FindByIdService.class);

    public Respuesta<Hero> findHeroById(Integer id) {
        logger.info("Hero.id recibida: "+id);
        Hero hero = HeroServiceUtil.findHeroByid(id, heroRepository);
        return new Respuesta<>(hero);
    }
}
