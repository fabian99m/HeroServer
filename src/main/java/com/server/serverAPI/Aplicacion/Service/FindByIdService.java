package com.server.serverAPI.Aplicacion.Service;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class FindByIdService {

    private final HeroRepository heroRepository;

    public Respuesta<Hero> findHeroById(Integer id) {
        Hero hero = HeroServiceUtil.findHeroByid(id, heroRepository);
        return new Respuesta<>(hero);
    }
}
