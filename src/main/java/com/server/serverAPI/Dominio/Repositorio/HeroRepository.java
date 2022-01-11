package com.server.serverAPI.Dominio.Repositorio;

import com.server.serverAPI.Dominio.Modelo.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroRepository {

    List<Hero> getAll();

    Hero save(Hero hero);

    Optional<List<Hero>> findByNameEquals(String name);

    Hero findById(Integer id);

    void deleteHero(Integer id);

}