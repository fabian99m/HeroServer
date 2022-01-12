package com.server.serverAPI.Infraestructura.Error;

public class ErrorGeneric extends RuntimeException {
    public ErrorGeneric(String mensaje) {
        super(mensaje);
    }
}
