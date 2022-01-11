package com.server.serverAPI.Infraestructura.Error;

public class HeroNoEncontrado extends RuntimeException {

    public HeroNoEncontrado(String mensaje) {
        super(mensaje);
    }

}
