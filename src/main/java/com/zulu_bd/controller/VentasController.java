package com.zulu_bd.controller;


import com.zulu_bd.model.Ventas;
import com.zulu_bd.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;



    @GetMapping
    public ResponseEntity<List<Ventas>> getVentas() {
        List<Ventas> ventas = ventasService.getVentas();
        return ResponseEntity.ok(ventas);

    }

    @PostMapping
    public ResponseEntity<Ventas> addVenta(@RequestBody Ventas venta) {

        Ventas nuevaVenta = ventasService.addVentas(venta);
        return ResponseEntity.ok(nuevaVenta);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Ventas> updateVenta(@PathVariable Integer id, @RequestBody Ventas venta) {
        try {
            Ventas ventaActualizada = ventasService.updateVentas(id, venta);
            return ResponseEntity.ok(ventaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Eliminar una venta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
        ventasService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }

}
