package com.server.serverAPI.Aplicacion.Service.Hero;

import com.server.serverAPI.Domain.Modelo.Hero;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Error.HeroNoEncontrado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HeroServiceUtil {

    static Logger logger = LoggerFactory.getLogger(HeroServiceUtil.class);

    public static Hero findHeroByid(Long id, HeroRepository heroRepository){
        Hero heroBd = heroRepository.findById(id);
        if(heroBd == null) {
            logger.warn("Hero no existente con Id: "+id);
            throw new HeroNoEncontrado("Hero no existente!");
        }
        return heroBd;
    }

    public static void existsById(Long id, HeroRepository heroRepository) {
        Boolean flag = heroRepository.existsById(id);
        if(!flag) {
            logger.warn("Hero no existente con Id: "+id);
            throw new HeroNoEncontrado("Hero no existente!");
        }
    }

    public static LocalDate convertirFecha(String fecha) {
        try {
            logger.info("Fecha recibida: "+fecha);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            return LocalDate.parse(fecha, formatter);
        } catch (DateTimeParseException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
