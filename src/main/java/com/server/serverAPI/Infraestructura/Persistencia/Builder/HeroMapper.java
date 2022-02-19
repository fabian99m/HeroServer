package com.server.serverAPI.Infraestructura.Persistencia.Builder;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeroMapper {

    @Mappings({
            @Mapping(source = "codigo",  target = "id"),
            @Mapping(source = "nombre",  target = "name"),
            @Mapping( target = "createdDate", ignore = true)
    })
    HeroEntity toHeroEntity(Hero hero);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "createdDate", target = "createdDate")
    })
    Hero toHero(HeroEntity heroEntity);

    List<Hero> toHeroList(List<HeroEntity> heroEntityList);

}
