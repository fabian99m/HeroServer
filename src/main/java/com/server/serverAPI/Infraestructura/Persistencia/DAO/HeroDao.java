package com.server.serverAPI.Infraestructura.Persistencia.DAO;

import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface HeroDao extends JpaRepository<HeroEntity, Long>, JpaSpecificationExecutor<HeroEntity> {

    Optional<List<HeroEntity>> findByNameEquals(String name);

}
