package com.server.serverAPI.Aplicacion.Service.Product;

import com.server.serverAPI.Domain.Modelo.Product;
import com.server.serverAPI.Domain.Repositorio.ProductRepository;
import com.server.serverAPI.Infraestructura.Error.CantidadIncorrecta;
import com.server.serverAPI.Infraestructura.Error.ProductoNoEncontrado;
import com.server.serverAPI.Infraestructura.Error.SinStockProducto;

public class ProductServiceUtil {

    public static void existsById(long id, ProductRepository productRepository) {
        Boolean flag = productRepository.existsById(id);
        if(!flag) {
            throw new ProductoNoEncontrado("Producto no existente!");
        }
    }

    public static Product findProductById(long codigo, ProductRepository productRepository){
        Product product = productRepository.findById(codigo);
        if(product == null) {
            throw new ProductoNoEncontrado("Producto no existente!");
        }
        return product;
    }

    public static void availablePurchase(int quantity, int stock) {
        if(stock < quantity || stock == 0) {
            throw new SinStockProducto("Producto sin stock disponible!");
        }

        if (quantity <= 0){
            throw new CantidadIncorrecta("Cantidad de compra incorrecta!");
        }
    }

    public static void updateStock(ProductRepository productRepository, Product product, int quantity) {
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }

}
