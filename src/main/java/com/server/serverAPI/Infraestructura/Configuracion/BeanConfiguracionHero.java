package com.server.serverAPI.Infraestructura.Configuracion;


import com.server.serverAPI.Aplicacion.Service.Hero.*;
import com.server.serverAPI.Aplicacion.Service.Product.SaveProductService;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Domain.Repositorio.ProductRepository;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.HeroMapper;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.ProductMapper;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.HeroDao;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.ProductDao;
import com.server.serverAPI.Infraestructura.Persistencia.Repository.Hero.HeroRepositoryImpl;
import com.server.serverAPI.Infraestructura.Persistencia.Repository.Product.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguracionHero {

    @Bean
    public DeleteHeroService DeleteHeroService(HeroRepository heroRepository) {return new DeleteHeroService(heroRepository);}

    @Bean
    public GetHeroByNameService GetHeroByNameService(HeroRepository heroRepository) {return new GetHeroByNameService(heroRepository);}

    @Bean
    public GetHerosService GetHerosService(HeroRepository heroRepository) {return new GetHerosService(heroRepository);}

    @Bean
    public SaveHeroService SaveHeroService(HeroRepository heroRepository) {return new SaveHeroService(heroRepository);}

    @Bean
    public UpdateNameService UpdateNamaService(HeroRepository heroRepository) {return new UpdateNameService(heroRepository);}

    @Bean
    public FindByDateBeforeService FindByDateBeforeService(HeroRepository heroRepository) {return new FindByDateBeforeService(heroRepository);}

    @Bean
    public FindByIdService FindByIdService(HeroRepository heroRepository) {return new FindByIdService(heroRepository);}

    @Bean
    public HeroRepositoryImpl HeroRepositoryImpl(HeroDao heroDao, HeroMapper heroMapper) {return new HeroRepositoryImpl(heroDao, heroMapper);}

    @Bean
    public ProductRepositoryImpl ProductRepositoryImpl(ProductDao productDao, ProductMapper productMapper) {return new ProductRepositoryImpl(productDao, productMapper);}

    @Bean
    public SaveProductService SaveProductService(ProductRepository productRepository) {return new SaveProductService(productRepository);}
}
