package com.server.serverAPI.Infraestructura.Persistencia.DAO;

import com.server.serverAPI.Infraestructura.Persistencia.Entidad.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductEntity, Long> { }
