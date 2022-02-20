package com.server.serverAPI.Domain.Repositorio;

import com.server.serverAPI.Domain.Modelo.Hero;

import java.time.LocalDate;
import java.util.List;

public interface HeroRepository {

    List<Hero> getAll();

    Hero save(Hero hero);

    List<Hero> findByNameEquals(String name);

    Hero findById(Long id);

    void deleteHero(Long id);

    Boolean existsById(Long id);

    List<Hero> findByName(String name);

    List<Hero> findByDateBefore(LocalDate date);
}
