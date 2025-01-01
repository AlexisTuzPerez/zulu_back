package com.zulu_bd.model;


import jakarta.persistence.*;

import java.util.Objects;


@Entity //Clase de JPA
@Table(name = "clientes") //Mapeo a la tabla
public class Clientes {

    //Hay que mapear cada columna, las restrincciones no son necesarias del todo

    @Id //the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // incremente automaticamente el id, ya configurado en la BD
    @Column(name = "cliente_id")
    private int id; //el nombre puede variar,pero es importante

    @Column(name="nombre_cliente")//Mapeo
    private String nombre;

    @Column(name="apellido_cliente")
    private String apellido;

    @Column(name="telefono_cliente")
    private String telefono;

    @Column(name="correo_cliente")
    private String correo;

    @Column(name="productos_comprados")
    private Integer productosComprados;




    public Clientes( String nombre,String apellido, String telefono,String  correo, Integer productosComprados) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.productosComprados = productosComprados;

    }

    public Clientes(){

    }

    public void setNombre_cliente(String nombre){
         this.nombre = nombre;
    }
    public void setApellido_cliente(String apellido){
         this.apellido = apellido;
    }

    public void setTelefono_cliente(String telefono){
         this.telefono = telefono;
    }
    public void setCorreo_cliente(String correo){
         this.correo = correo;
    }

    public void setProductosComprados(Integer productosComprados) {
        this.productosComprados = productosComprados;
    }

    public void setId(int id) {

        this.id=id;
    }
    //sin los getter, no retorna los atributos, pasó con el id
    public  int getId() {
        return id;
    }
    public String getNombre() {

        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {

        return telefono;
    }
    public String getCorreo() {

        return correo;
    }


    public Integer getProductosComprados() {
        return productosComprados;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return Objects.equals(id,clientes.id) && Objects.equals(nombre, clientes.nombre) && Objects.equals(apellido, clientes.apellido) && Objects.equals(telefono, clientes.telefono) && Objects.equals(clientes, clientes.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, telefono, correo);
    }


    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", productosComprados=" + productosComprados +
                '}';
    }
}



