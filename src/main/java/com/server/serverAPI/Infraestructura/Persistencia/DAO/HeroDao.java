package com.server.serverAPI.Infraestructura.Persistencia.DAO;

import com.server.serverAPI.Infraestructura.Persistencia.Entidad.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HeroDao extends JpaRepository<HeroEntity, Integer> {

    Optional<List<HeroEntity>> findByNameEquals(String name);
}
