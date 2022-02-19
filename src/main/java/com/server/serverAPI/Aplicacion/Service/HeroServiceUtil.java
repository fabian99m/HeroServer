package com.server.serverAPI.Aplicacion.Service;

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

    public static  Hero findHeroByid(Integer codigo, HeroRepository heroRepository){
        Hero heroBd = heroRepository.findById(codigo);
        if(heroBd == null) {
            throw new HeroNoEncontrado("Hero no existente!");
        }
        return heroBd;
    }

    public static Boolean existsById(Integer codigo, HeroRepository heroRepository) {
        Boolean flag = heroRepository.existsById(codigo);
        if(!flag) {
            throw new HeroNoEncontrado("Hero no existente!");
        }
        return true;
    }

    public static LocalDate convertirFecha(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            return LocalDate.parse(fecha, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }

      /*  Date dateout;
        try { dateout = new SimpleDateFormat("dd/MM/yyyy").parse(fecha); }
        catch (ParseException e) {
            dateout = null;
            logger.warn(e.toString());
        }
        return dateout;*/
    }

}
