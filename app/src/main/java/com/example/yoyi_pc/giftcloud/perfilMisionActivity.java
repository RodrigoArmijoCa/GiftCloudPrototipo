package com.example.yoyi_pc.giftcloud;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class perfilMisionActivity  extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfilmision);
        String nombre = getIntent().getStringExtra("nombre");
        String descripcion = getIntent().getStringExtra("descripcion");
        String nombreImagen = getIntent().getStringExtra("nombreImagen");
        String empresaObjetivo = getIntent().getStringExtra("empresaObjetivo");
        String proposito = getIntent().getStringExtra("proposito");
        String sensoresSolicitados = getIntent().getStringExtra("sensoresSolicitados");
        TextView nombreElemento = findViewById(R.id.nombreMision);
        nombreElemento.setText(nombre);
        TextView descripcionElemento = findViewById(R.id.descripcionMision);
        descripcionElemento.setText(descripcion);
        ImageView imagen = (ImageView) findViewById(R.id.imagenMision);
        Context context = imagen.getContext();
        int id = context.getResources().getIdentifier(nombreImagen, "drawable", context.getPackageName());
        imagen.setImageResource(id);
        TextView empresaObjet = findViewById(R.id.nombreEmpresaDestino);
        empresaObjet.setText(empresaObjetivo);
        TextView sensSolic = findViewById(R.id.sensoresSolicitados);
        sensSolic.setText(sensoresSolicitados);

    }

}
