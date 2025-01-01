package com.zulu_bd.controller;


import com.zulu_bd.model.Clientes;
import com.zulu_bd.model.Productos;
import com.zulu_bd.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping
    public ResponseEntity<List<Productos>> getProductos(){

        List<Productos> productos = productosService.findAll();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProducto(@PathVariable int id){

        Productos producto = productosService.findById(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Productos> addProducto(@RequestBody Productos producto){

        try {

            Productos nuevoProducto = productosService.addProducto(producto);
            return ResponseEntity.ok(nuevoProducto);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProducto(@PathVariable int id, @RequestBody Productos producto){

        try {
            Productos productoActualizado = productosService.updateProducto(id, producto);
            return ResponseEntity.ok(productoActualizado);
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable int id){

        try{
            productosService.deleteProducto(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }



}

