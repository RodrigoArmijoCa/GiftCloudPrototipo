package com.example.yoyi_pc.giftcloud;

/**
 * Created by Yoyi-PC on 26-08-2018.
 */

public class Producto
{
    private String nombre;
    private String descripcion;
    private String nombreImagenProducto;
    private Integer precio;

    public Producto(String nombre, String descripcion, String nombreImagenProducto, Integer precio)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreImagenProducto = nombreImagenProducto;
        this.precio = precio;
    }

    public String getNombre()
    {
        return this.nombre;
    }
    public String getDescripcion()
    {
        return this.descripcion;
    }
    public String getNombreImagenProducto()
    {
        return this.nombreImagenProducto;
    }
    public Integer getPrecio()
    {
        return this.precio;
    }
}
