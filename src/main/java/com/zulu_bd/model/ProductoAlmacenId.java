package com.zulu_bd.model;

import java.io.Serializable;



//creat a class that works as an compund key. The table entity use ProductoAlmacenId as an Id
public class ProductoAlmacenId implements Serializable {


    private int productoId;
    private int almacenId;


    public  ProductoAlmacenId() {

    }

    public ProductoAlmacenId(int productoId, int almacenId) {
        this.productoId = productoId;
        this.almacenId = almacenId;
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


}
