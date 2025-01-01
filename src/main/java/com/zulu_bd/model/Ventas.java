package com.zulu_bd.model;


import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Document(collection = "ventas") // a la coleción
public class Ventas {

    @Id
    private Integer id;

    private int cliente_id;

    private List<Map<String, Object>> productos;
    private String tipoDePago;


    public Ventas(Integer id, int cliente_id, List<Map<String, Object>> productos, String tipoDePago) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.productos = productos;
        this.tipoDePago = tipoDePago;
    }

    public Ventas() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public List<Map<String, Object>> getProductos() {
        return productos;
    }

    public void setProductos(List<Map<String, Object>>productos) {
        this.productos = productos;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ventas ventas = (Ventas) o;
        return cliente_id == ventas.cliente_id && Objects.equals(id, ventas.id) && Objects.equals(productos, ventas.productos) && Objects.equals(tipoDePago, ventas.tipoDePago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente_id, productos, tipoDePago);
    }
}
