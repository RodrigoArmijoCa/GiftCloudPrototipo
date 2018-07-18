package com.example.yoyi_pc.giftcloud;

/**
 * Created by Yoyi-PC on 17-07-2018.
 */

public class Mision {

    String nombre;
    String descripcion;

    public Mision(String nombre, String descripcion)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }



}
