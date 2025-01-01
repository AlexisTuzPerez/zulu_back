package com.zulu_bd.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;


@Entity
@IdClass(ProductoAlmacenId.class)  // the compound key
public class ProductoAlmacen {




    @Id
    @Column(name="producto_id")
    private int productoId;


    @Id
    @Column(name="almacen_id")
    private int almacenId;


    @Column(name="cantidad")
    private int cantidad;


    public ProductoAlmacen(int productoId, int almacenId, int cantidad) {
        this.productoId = productoId;
        this.almacenId = almacenId;
        this.cantidad = cantidad;
    }


    public ProductoAlmacen() {

    }
    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(int almacenId) {
        this.almacenId = almacenId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
