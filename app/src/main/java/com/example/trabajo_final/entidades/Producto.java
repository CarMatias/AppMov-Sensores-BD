package com.example.trabajo_final.entidades;

public class Producto {
    private String nombre;
    private String precio;
    private String categoria;
    private String descripcion;
    private String foto;

    public Producto(String nombre, String precio, String categoria, String descripcion, String foto){
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String   getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public String getFoto() {
        return foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFoto(String descripcion) {
        this.foto = foto;
    }
}
