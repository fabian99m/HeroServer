package com.server.serverAPI.Aplicacion.Service;

import com.server.serverAPI.Dominio.Modelo.Hero;
import com.server.serverAPI.Dominio.Repositorio.HeroRepository;
import com.server.serverAPI.Infraestructura.Error.HeroNoEncontrado;

 public class HeroServiceUtil {
    
    public static  Hero findHeroByid(Integer codigo, HeroRepository heroRepository){
        Hero heroBd = heroRepository.findById(codigo);
        if(heroBd == null) {
            throw new HeroNoEncontrado("Hero no existente!");
        }
        return heroBd;
    }


}
