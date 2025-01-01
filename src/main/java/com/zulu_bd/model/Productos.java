package com.zulu_bd.model;

import jakarta.persistence.*;

import java.util.Objects;



@Entity
@Table(name="productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="autor")
    private String autor;

    @Column(name="categoria")
    private String categoria;

    @Column(name="fecha_lanzamiento")
    private String fecha_lanzamiento;

    @Column(name="precio")
    private Double precio;


    public Productos(int id, String nombre, String autor, String categoria, String fecha_lanzamiento, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.fecha_lanzamiento = fecha_lanzamiento;
        this.precio = precio;
    }

    public Productos() {

    }


    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(String fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fecha_lanzamiento='" + fecha_lanzamiento + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Productos productos = (Productos) o;
        return id == productos.id && Objects.equals(nombre, productos.nombre) && Objects.equals(autor, productos.autor) && Objects.equals(categoria, productos.categoria) && Objects.equals(fecha_lanzamiento, productos.fecha_lanzamiento) && Objects.equals(precio, productos.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, autor, categoria, fecha_lanzamiento, precio);
    }
}
