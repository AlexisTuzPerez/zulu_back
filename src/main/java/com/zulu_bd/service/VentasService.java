package com.zulu_bd.service;


import com.zulu_bd.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zulu_bd.model.Ventas;
import com.zulu_bd.model.Productos;

import java.util.List;
import java.util.Map;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private ProductosService productosService;



    public List<Ventas> getVentas() {
        return ventasRepository.findAll();
    }

    public Ventas findById(Integer id) {
        return ventasRepository.findById(id).get();
    }

    public Ventas addVentas(Ventas ventas) {
        return ventasRepository.save(ventas);
    }


    public Ventas updateVentas(Integer id,Ventas venta) {

        Ventas ventaExistente = ventasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + id));



        ventaExistente.setCliente_id(venta.getCliente_id());
        ventaExistente.setProductos(venta.getProductos());
        ventaExistente.setTipoDePago(venta.getTipoDePago());
        return ventasRepository.save(ventaExistente);

    }

    public void deleteVenta(Integer id) {
        ventasRepository.deleteById(id);
    }




}
