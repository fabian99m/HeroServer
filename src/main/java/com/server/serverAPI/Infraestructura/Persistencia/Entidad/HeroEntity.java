package com.server.serverAPI.Infraestructura.Persistencia.Entidad;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hero")
@Data
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDate createdDate;

}
