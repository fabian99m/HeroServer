package com.server.serverAPI.Infraestructura.Persistencia.Repository.Hero;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.HeroMapper;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.HeroDao;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<Hero> findByNameEquals(String name) {
        Optional<List<HeroEntity>> heroOptionalEntity = heroCRUD.findByNameEquals(name);
        return heroOptionalEntity
                .map(heroMapper::toHeroList)
                .orElseGet(ArrayList::new);
    }

    @Override
    public Hero findById(Long id) {
       return heroCRUD.findById(id)
               .map(heroMapper::toHero)
               .orElse(null);
    }

    @Override
    public void deleteHero(Long id) {
        heroCRUD.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return heroCRUD.existsById(id);
    }

    public List<Hero> findByName(String name){
        Specification<HeroEntity> specification = HeroSpecifications.nameEquals(name); //criteriaQuery builder
        List<HeroEntity> heroEntityList = heroCRUD.findAll(specification);

        return heroMapper.toHeroList(heroEntityList);
    }

    @Override
    public List<Hero> findByDateBefore(LocalDate date) {
            Specification<HeroEntity> specification = HeroSpecifications.beforeOf(date);
            List<HeroEntity> heroEntityList = heroCRUD.findAll(specification);

            return heroMapper.toHeroList(heroEntityList);
    }

}