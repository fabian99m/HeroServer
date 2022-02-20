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
    private Long purchaseId;

    @ManyToOne()
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;

    @ManyToOne()
    @JoinColumn(name = "hero_id", referencedColumnName = "id")
    private HeroEntity client;

    private int quantity;

}
