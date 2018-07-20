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
    int recompensa;
    boolean isSelected;
    boolean arealizar;
    boolean noRealizada;

    public Mision(int id, String nombre, String descripcion, String nombreImagen)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreImagen = nombreImagen;
        this.recompensa = 2;
        this.isSelected = false;
        this.noRealizada = true;
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

    public int getRecompensa(){return this.recompensa;}

    public void setRecompensa(int recompensa){this.recompensa = recompensa;}

    public boolean getnoRealizada(){return this.noRealizada;}

    public void setnoRealizada(boolean noRealizada){this.noRealizada = noRealizada;}

}
