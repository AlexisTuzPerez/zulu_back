package com.zulu_bd.service;


import com.zulu_bd.model.ProductoAlmacen;
import com.zulu_bd.model.ProductoAlmacenId;
import com.zulu_bd.repository.ProductoAlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoAlmacenService {

    @Autowired
    private ProductoAlmacenRepository productoAlmacenRepository;



    public List<ProductoAlmacen> findAll() {
        return productoAlmacenRepository.findAll();
    }

    public ProductoAlmacen findById(ProductoAlmacenId id) {
        return productoAlmacenRepository.findById(id).get();
    }


    public ProductoAlmacen addProductoAlmacen(ProductoAlmacen productoAlmacen) {
        return productoAlmacenRepository.save(productoAlmacen);
    }

    public ProductoAlmacen updateProductoAlmacen(ProductoAlmacenId id, ProductoAlmacen productoAlmacen) {

        ProductoAlmacen productoAlmacenExistente = productoAlmacenRepository.findById(id).get();

        if (productoAlmacenExistente == null) {
            throw new RuntimeException("Almacen id no encontrado.");

        }

        productoAlmacenExistente.setCantidad(productoAlmacen.getCantidad());

        return productoAlmacenRepository.save(productoAlmacenExistente);

    }

    public void deleteProductoAlmacen(ProductoAlmacenId id) {

        ProductoAlmacen productoAlmacen = productoAlmacenRepository.findById(id).get();

        if (productoAlmacen == null) {
            throw new RuntimeException("Almacen id no encontrado.");
        }

        productoAlmacenRepository.delete(productoAlmacen);

    }



    public List<Object[]> findAllDetailed(){

        return  productoAlmacenRepository.findAllDetailed();
    }


    public String validarProducto(int cantidad,  int clienteId,int productoId) {
        return productoAlmacenRepository.callValidacionProducto(cantidad, clienteId,productoId);
    }

}
