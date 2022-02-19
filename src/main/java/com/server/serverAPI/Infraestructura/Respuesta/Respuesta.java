package com.server.serverAPI.Infraestructura.Respuesta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Respuesta<T> implements Serializable {
    
    private T datos;
    private String mensaje = "";
   // private int status;

    public Respuesta(T dato){
        this.datos = dato;
        this.mensaje = HttpStatus.OK.getReasonPhrase();
      //  this.status = HttpStatus.OK.value();
    }

    public Respuesta(String mensaje, T dato){
        this.datos = dato;
        this.mensaje = mensaje;
    }

    public Respuesta(String mensaje){
        this.mensaje = mensaje;
        this.datos=null;
    }

    public Respuesta(HttpStatus httpStatus, T dato){
        this.datos = dato;
       // this.status = httpStatus.value();
    }

   
}
