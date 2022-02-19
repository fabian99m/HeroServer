package com.server.serverAPI.Infraestructura.Persistencia.Repository;

import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class HeroSpecifications {

    public static Specification<HeroEntity> nameEquals(String name) {
        return (heroEntityRoot, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .equal(heroEntityRoot.get("name"), name);
    }

    public static Specification<HeroEntity> beforeOf(LocalDate date) {
        return (heroEntityRoot, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .lessThan(heroEntityRoot.get("createdDate"), date);
    }

}