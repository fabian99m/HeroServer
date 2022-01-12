package com.server.serverAPI.Infraestructura.Persistencia.Repository;

import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;
import org.springframework.data.jpa.domain.Specification;

public class HeroSpecifications {

    static Specification<HeroEntity> nameEquals(String name) {
        return (heroEntityRoot, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(heroEntityRoot.get("name"), name);
    }

}