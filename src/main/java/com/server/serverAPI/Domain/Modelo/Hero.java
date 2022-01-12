package com.server.serverAPI.Domain.Modelo;

import lombok.Data;

import java.util.Date;

@Data
public class Hero {

    private int codigo;

    private String nombre;

    private Date createdDate;

}
