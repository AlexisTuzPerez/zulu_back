package com.zulu_bd.controller;


import com.zulu_bd.model.ProductoAlmacen;
import com.zulu_bd.model.ProductoAlmacenId;
import com.zulu_bd.service.ProductoAlmacenService;
import com.zulu_bd.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productoAlmacen")
public class ProductoAlmacenController {


    @Autowired
    private ProductoAlmacenService productoAlmacenService;
    @Autowired
    private ProductosService productosService;

    @GetMapping
    public ResponseEntity<List<ProductoAlmacen>> findAll(){
        List<ProductoAlmacen> productoAlmacen = productoAlmacenService.findAll();
        return ResponseEntity.ok(productoAlmacen);
    }


    @GetMapping("/{productoId}/{almacenId}")
    public ResponseEntity<ProductoAlmacen> findById( @PathVariable("productoId") int productoId,
                                                     @PathVariable("almacenId") int almacenId){

        ProductoAlmacenId productoAlmacenId = new ProductoAlmacenId(productoId, almacenId);
        return ResponseEntity.ok(productoAlmacenService.findById(productoAlmacenId));

    }


    @GetMapping("/detalles")
    public ResponseEntity<List<Object[]>> findAllDetailed(){

        return ResponseEntity.ok(productoAlmacenService.findAllDetailed());
    }

    @PostMapping
    public ResponseEntity<ProductoAlmacen> addProductoAlmacen( @RequestBody ProductoAlmacen productoAlmacen){

        try {
            ProductoAlmacen nuevoProductoAlmacen = productoAlmacenService.addProductoAlmacen(productoAlmacen);
            return ResponseEntity.ok(nuevoProductoAlmacen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{productoId}/{almacenId}")
    public ResponseEntity<ProductoAlmacen> updateProductoAlmacen(@PathVariable int productoId,
                                                                 @PathVariable int almacenId,
                                                                 @RequestBody ProductoAlmacen productoAlmacen){
        try{

            ProductoAlmacenId id = new ProductoAlmacenId(productoId, almacenId);
            ProductoAlmacen productoAlmacenExistente = productoAlmacenService.updateProductoAlmacen(id, productoAlmacen);

            return ResponseEntity.ok(productoAlmacenExistente);
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{productoId}/{almacenId}")
    public ResponseEntity<Void> deleteProductoAlmacen( @PathVariable int productoId, @PathVariable int almacenId){
        try{
            ProductoAlmacenId id = new ProductoAlmacenId(productoId, almacenId);
            productoAlmacenService.deleteProductoAlmacen(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }

    }


    @PostMapping("/funcion")
    public ResponseEntity<String> validarProducto(
            @RequestParam int cantidad,
            @RequestParam int clienteId,
            @RequestParam int productoId) {
        String resultado = productoAlmacenService.validarProducto(cantidad, clienteId,productoId);
        return ResponseEntity.ok(resultado);
    }




}
