package com.example.yoyi_pc.giftcloud;

import android.graphics.drawable.Drawable;

/**
 * Created by Yoyi-PC on 17-07-2018.
 */

public class Mision {

    int id;
    String nombre;
    String descripcion;
    String nombreImagen;
    boolean isSelected;
    boolean arealizar;

    public Mision(int id, String nombre, String descripcion, String nombreImagen)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreImagen = nombreImagen;
        this.isSelected = false;
    }

    public int getId()
    {
        return this.id;
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

    public boolean isSelected() {return this.isSelected;}

    public void setSelected(boolean eleccion) {this.isSelected = eleccion;}

    public void setARealizar(boolean eleccion) {this.arealizar = eleccion;}

    public boolean getARealizar() {return arealizar;}

}
