package com.server.serverAPI.Infraestructura.Error.ExceptionHandler;

import com.server.serverAPI.Infraestructura.Error.ErrorGeneric;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ErrorGeneric.class)
    @ResponseBody
    ResponseEntity<Respuesta<String>> handleServiceException(ErrorGeneric exception){
        return new ResponseEntity<>(new Respuesta<>(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
