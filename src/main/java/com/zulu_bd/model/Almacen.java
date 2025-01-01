package com.zulu_bd.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "almacen")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="almacen_id")
    private int id;

    @Column(name="nombre")
    private String nombre;


    public Almacen(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    // el constructor vacío es importante
    public Almacen() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
