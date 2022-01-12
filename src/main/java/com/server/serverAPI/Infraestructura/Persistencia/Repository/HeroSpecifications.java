package com.server.serverAPI.Infraestructura.Persistencia.Repository;

import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class HeroSpecifications {

    static Specification<HeroEntity> nameEquals(String name) {
        return (heroEntityRoot, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(heroEntityRoot.get("name"), name);
    }

    static Specification<HeroEntity> beforeOf(Date date) {
        return (heroEntityRoot, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThan(heroEntityRoot.get("createDate"), date);
    }

}