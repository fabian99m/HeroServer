package com.server.serverAPI.Infraestructura.Persistencia.Builder;


import com.server.serverAPI.Dominio.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeroMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id"),
            @Mapping(source = "nombre", target = "name"),
    })
    HeroEntity toHeroEntity(Hero hero);

    @InheritInverseConfiguration
    Hero toHero(HeroEntity heroEntity);

    List<Hero> toHeroList(List<HeroEntity> heroEntityList);

}
