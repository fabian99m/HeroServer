package com.server.serverAPI.Aplicacion.Service;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Respuesta.Respuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class FindByDateBeforeService {

    private final HeroRepository heroRepository;

    public ResponseEntity<Respuesta<List<Hero>>> findByDateBefore(String fecha) {
        LocalDate date = HeroServiceUtil.convertirFecha(fecha);
        if(null == date) {
            return new ResponseEntity<>(new Respuesta<>("Formato de fecha incorrecto!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<Hero> heroList = heroRepository.findByDateBefore(date);
        return heroList.isEmpty()
                ? new ResponseEntity<>(new Respuesta<>("No se encontraron héroes con fecha de creación antes de "+fecha), HttpStatus.OK)
                : new ResponseEntity<>(new Respuesta<>("Héroes encontrados con éxito!",heroList), HttpStatus.OK);
    }

}
