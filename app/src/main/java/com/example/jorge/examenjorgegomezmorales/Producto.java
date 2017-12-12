package com.example.jorge.examenjorgegomezmorales;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jorge on 12/12/17.
 */

public class Producto implements Serializable {

    // ATRIBUTOS
    private int idProducto;
    private String nombreProducto;
    private int imagen;
    private double precio;
    private String descripcion;
    private int[] galeriaImagenes;

    // CONSTRUCTOR POR DEFECTO
    public Producto() {}

    // CONSTRUCTOR CON PARAMETROS

    public Producto(int idProducto, String nombreProducto, int imagen, double precio, String descripcion, int[] galeriaImagenes) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.imagen = imagen;
        this.precio = precio;
        this.descripcion = descripcion;
        this.galeriaImagenes = galeriaImagenes;
    }

    // METODOS GET Y SET

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int[] getGaleriaImagenes() {
        return galeriaImagenes;
    }

    public void setGaleriaImagenes(int[] galeriaImagenes) {
        this.galeriaImagenes = galeriaImagenes;
    }
}
