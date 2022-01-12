package com.server.serverAPI.Infraestructura.Configuracion;


import com.server.serverAPI.Aplicacion.Service.HeroService;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.server.serverAPI.Infraestructura.Persistencia.Builder.HeroMapper;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.HeroDao;
import com.server.serverAPI.Infraestructura.Persistencia.Repository.HeroRepositoryImpl;


@Configuration
public class BeanConfiguracionHero {

    @Bean
    public HeroService heroService(HeroRepository heroRepository) {return new HeroService(heroRepository);}

    @Bean
    public HeroRepositoryImpl HeroRepositoryImpl(HeroDao heroDao, HeroMapper heroMapper) {return new HeroRepositoryImpl(heroDao, heroMapper);}

}
