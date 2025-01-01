package com.zulu_bd.service;


import com.zulu_bd.model.Productos;
import com.zulu_bd.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

@Service
public class ProductosService {


    @Autowired
    private ProductosRepository productosRepository;
    @Autowired
    private ResourceUrlProvider resourceUrlProvider;


    public List<Productos> findAll(){
        return productosRepository.findAll();
    }


    public   Productos findById(int id){
        return productosRepository.findById(id);
    }

    public Productos updateProducto(int id, Productos producto){

        Productos productoExistente = productosRepository.findById( id);


        if(productoExistente == null){

            throw new RuntimeException("Producto con ID " + id + " no encontrado.");
        }
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setAutor(producto.getAutor());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setFecha_lanzamiento(producto.getFecha_lanzamiento());
        productoExistente.setPrecio(producto.getPrecio());
        return productosRepository.save(productoExistente);
    }


    public  Productos addProducto(Productos producto){
        producto.setId(0);
        return productosRepository.save(producto);
    }

    public void deleteProducto(int id){
        Productos productoExistente = productosRepository.findById(id);

        if(productoExistente == null){
            throw new RuntimeException("Producto con ID " + id + " no encontrado.");
        }

        productosRepository.delete(productoExistente);

    }
}
