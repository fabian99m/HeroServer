package com.server.serverAPI.Infraestructura.Persistencia.Entidad;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "purchase")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int purchaseId;

    @ManyToOne
    private ProductEntity product;

    @ManyToOne
    private HeroEntity client;

    private int quantity;


}
