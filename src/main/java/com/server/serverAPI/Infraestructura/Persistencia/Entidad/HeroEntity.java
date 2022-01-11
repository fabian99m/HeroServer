package com.server.serverAPI.Infraestructura.Persistencia.Entidad;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hero")
@Data
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    private String name;
}
