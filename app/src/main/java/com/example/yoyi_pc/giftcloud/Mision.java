package com.example.yoyi_pc.giftcloud;

import android.graphics.drawable.Drawable;

/**
 * Created by Yoyi-PC on 17-07-2018.
 */

public class Mision {

    String nombre;
    String descripcion;
    String nombreImagen;

    public Mision(String nombre, String descripcion)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Mision(String nombre, String descripcion, String nombreImagen)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreImagen = nombreImagen;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }

    public String getNombreImagen()
    {
        return this.nombreImagen;
    }



}
