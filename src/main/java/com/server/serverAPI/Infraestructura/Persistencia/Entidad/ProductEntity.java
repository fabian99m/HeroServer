package com.server.serverAPI.Infraestructura.Persistencia.Entidad;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private int stock;

  /*  @ManyToOne
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchase;
*/

}
