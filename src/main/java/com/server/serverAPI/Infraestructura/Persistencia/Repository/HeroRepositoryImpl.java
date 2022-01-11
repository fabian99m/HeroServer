package com.server.serverAPI.Infraestructura.Persistencia.Repository;


import com.server.serverAPI.Dominio.Modelo.Hero;
import com.server.serverAPI.Dominio.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.HeroMapper;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.HeroDao;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class HeroRepositoryImpl implements HeroRepository {

    private final HeroDao heroCRUD;
    private final HeroMapper heroMapper;

    @Override
    public List<Hero> getAll() {
        List<HeroEntity> heroEntityList = heroCRUD.findAll();
        return heroMapper.toHeroList(heroEntityList);
    }

    @Override
    public Hero save(Hero hero) {
        HeroEntity heroEntity = heroCRUD.save(heroMapper.toHeroEntity(hero));
        return heroMapper.toHero(heroEntity);
    }

    @Override
    public Optional<List<Hero>> findByNameEquals(String name) {
        Optional<List<HeroEntity>> heroOptionalEntity = heroCRUD.findByNameEquals(name);
        return heroOptionalEntity.map(list -> heroMapper.toHeroList(list));
    }

    @Override
    public Hero findById(Integer id) {
       return heroCRUD.findById(id)
               .map(heroEntity -> heroMapper.toHero(heroEntity))
               .orElse(null);
    }

    @Override
    public void deleteHero(Integer id) {
        heroCRUD.deleteById(id);
    }

}
