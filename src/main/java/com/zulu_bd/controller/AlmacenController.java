package com.zulu_bd.controller;


import com.zulu_bd.model.Almacen;
import com.zulu_bd.service.AlmacenService;
import com.zulu_bd.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacen")
public class AlmacenController {


    @Autowired
    private AlmacenService almacenService;
    @Autowired
    private ProductosService productosService;


    @GetMapping
    public ResponseEntity<List<Almacen>> getAlmacen() {

        List<Almacen> almacen = almacenService.findAll();

        return ResponseEntity.ok(almacen);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Almacen> getAlmacenById(@PathVariable int id) {
        Almacen almacen = almacenService.findById(id);

        return ResponseEntity.ok(almacen);
    }

    @PostMapping
    public ResponseEntity<Almacen> addAlmacen(@RequestBody Almacen almacen) {
        try{
            almacenService.addAlmacen(almacen);
            return ResponseEntity.ok(almacen);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{id}")
    ResponseEntity<Almacen> updateAlmacen(@PathVariable int id,  @RequestBody Almacen almacen) {
        try {
            Almacen almacenActualizado = almacenService.updateAlmacen(id, almacen);
            return ResponseEntity.ok(almacenActualizado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteAlmacen(@PathVariable int id) {
        try{
            almacenService.deleteAlmacen(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
