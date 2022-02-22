package com.server.serverAPI.Aplicacion.Service.Product;

import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Domain.Repositorio.ProductRepository;
import com.server.serverAPI.Infraestructura.Error.CantidadIncorrecta;
import com.server.serverAPI.Infraestructura.Error.ProductoNoEncontrado;
import com.server.serverAPI.Infraestructura.Error.SinStockProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductServiceUtil {

    static Logger logger = LoggerFactory.getLogger(ProductServiceUtil.class);

    public static void existsById(long id, ProductRepository productRepository) {
        Boolean flag = productRepository.existsById(id);
        if(!flag) {
            logger.warn("Producto no existente con Id: "+id);
            throw new ProductoNoEncontrado("Producto no existente!");
        }
    }

    public static Product findProductById(long id, ProductRepository productRepository){
        Product product = productRepository.findById(id);
        if(product == null) {
            logger.warn("Producto no existente con Id: "+id);
            throw new ProductoNoEncontrado("Producto no existente!");
        }
        return product;
    }

    public static void availablePurchase(int quantity, int stock) {
        if(stock == 0) {
            logger.warn("Producto sin stock disponible, 0 unidades");
            throw new SinStockProducto("Producto sin stock disponible!");
        }

        if (quantity <= 0){
            logger.warn("Cantidad de compra incorrecta: "+quantity);
            throw new CantidadIncorrecta("Cantidad de compra incorrecta!");
        }

        if(stock < quantity) {
            logger.warn("Producto sin stock suficiente");
            throw new SinStockProducto("Producto con stock insuficiente!, cantidad requerida: "+quantity+" -- stock disponible: "+stock);
        }
    }

    public static void updateStock(ProductRepository productRepository, Product product, int quantity) {
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }

}
