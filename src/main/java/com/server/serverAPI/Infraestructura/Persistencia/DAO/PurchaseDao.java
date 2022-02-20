package com.server.serverAPI.Infraestructura.Persistencia.DAO;


import com.server.serverAPI.Infraestructura.Persistencia.Entidad.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDao extends JpaRepository<PurchaseEntity, Integer> { }
