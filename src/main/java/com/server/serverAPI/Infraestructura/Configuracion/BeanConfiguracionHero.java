package com.server.serverAPI.Infraestructura.Configuracion;


import com.server.serverAPI.Aplicacion.Service.Hero.*;
import com.server.serverAPI.Aplicacion.Service.Product.SaveProductService;
import com.server.serverAPI.Aplicacion.Service.Purchase.ListAllPurchasesService;
import com.server.serverAPI.Aplicacion.Service.Purchase.ListPurchasesByIdHeroService;
import com.server.serverAPI.Aplicacion.Service.Purchase.SavePurchaseService;
import com.server.serverAPI.Domain.Repositorio.HeroRepository;
import com.server.serverAPI.Domain.Repositorio.ProductRepository;
import com.server.serverAPI.Domain.Repositorio.PurchaseRepository;
import com.server.serverAPI.Infraestructura.Persistencia.Builder.*;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.HeroDao;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.ProductDao;
import com.server.serverAPI.Infraestructura.Persistencia.DAO.PurchaseDao;
import com.server.serverAPI.Infraestructura.Persistencia.Repository.Hero.HeroRepositoryImpl;
import com.server.serverAPI.Infraestructura.Persistencia.Repository.Product.ProductRepositoryImpl;
import com.server.serverAPI.Infraestructura.Persistencia.Repository.Purchase.PurchaseRepositoryImpl;
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

    @Bean
    public PurchaseRepositoryImpl PurchaseRepositoryImpl(PurchaseDao purchaseDao, PurchaseMapper purchaseMapper, ListPurchaseBuilder listPurchaseBuilder, ProductDTOMapper productDTOMapper) {
        return new PurchaseRepositoryImpl(purchaseDao, purchaseMapper, listPurchaseBuilder, productDTOMapper);
    }

    @Bean
    public SavePurchaseService SavePurchaseService(PurchaseRepository purchaseRepository, HeroRepository heroRepository, ProductRepository productRepository) {
        return new SavePurchaseService(purchaseRepository, heroRepository, productRepository);
    }

    @Bean
    public ListAllPurchasesService ListAllPurchasesService(PurchaseRepository purchaseRepository) {
        return new ListAllPurchasesService(purchaseRepository);
    }

    @Bean
    public ListPurchasesByIdHeroService ListPurchasesByIdHeroService(PurchaseRepository purchaseRepository, HeroRepository heroRepository) {
        return new ListPurchasesByIdHeroService(purchaseRepository, heroRepository);
    }

}
