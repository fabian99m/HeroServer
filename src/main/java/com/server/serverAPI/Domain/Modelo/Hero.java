package com.server.serverAPI.Domain.Modelo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Hero {

    private Long codigo;

    private String nombre;

    private LocalDate createdDate;

}
