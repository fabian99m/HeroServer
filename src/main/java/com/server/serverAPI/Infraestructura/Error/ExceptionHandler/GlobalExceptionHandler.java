package com.server.serverAPI.Infraestructura.Error.ExceptionHandler;

import com.server.serverAPI.Infraestructura.Error.HeroNoEncontrado;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(HeroNoEncontrado.class)
    @ResponseBody
    ResponseEntity<Respuesta<String>> handleServiceException(HeroNoEncontrado error){
        return new ResponseEntity<>(new Respuesta<>(error.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        //return new Respuesta<>(HttpStatus.INTERNAL_SERVER_ERROR, error.getMessage());
    }

}
