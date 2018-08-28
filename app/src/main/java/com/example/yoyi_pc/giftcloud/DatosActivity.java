package com.example.yoyi_pc.giftcloud;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

import java.util.ArrayList;

public class DatosActivity extends AppCompatActivity
{
    final float mSeriesMax = 100f;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_activity);
        DecoView arcView = (DecoView)findViewById(R.id.grafSensoresUsados);
        DecoView graficoMb = (DecoView)findViewById(R.id.grafSensoresUsadosmb);
        if (MainActivity.cantidadesDeDatos.get(0) == 0)
        {
            TextView textoDeEntregadoNada = findViewById(R.id.textoDeNoEntregadoNada);
            textoDeEntregadoNada.setVisibility(View.VISIBLE);
            ImageView imagenTriste = findViewById(R.id.caritaTriste);
            imagenTriste.setVisibility(View.VISIBLE);
        }
        else
        {
            TextView textoDePorc = findViewById(R.id.stringDatosEntregados);
            TextView textoDeKb = findViewById(R.id.stringDatosEntregadosKB);
            textoDePorc.setVisibility(View.VISIBLE);
            arcView.setVisibility(View.VISIBLE);
            textoDeKb.setVisibility(View.VISIBLE);
            graficoMb.setVisibility(View.VISIBLE);
            inicializarGrafSensoresPorcen(arcView);
            inicializarGrafSensoresMB(graficoMb);
        }
    }

    public void inicializarGrafSensoresPorcen(DecoView arcView)
    {
        ArrayList<String> listaDeNombresSensores = inicializarListaDeNombresDeSensores();
        ArrayList<Integer> listaDeColores = inicializarListaDeColores();
        ArrayList<Integer> listaDeIndex = new ArrayList<Integer>();
        ArrayList<Integer> listaDePorcentajes = new ArrayList<Integer>();
        arcView.addSeries(new SeriesItem.Builder(Color.argb(120, 0, 0, 118))
                .setRange(0, mSeriesMax, mSeriesMax)
                .setChartStyle(SeriesItem.ChartStyle.STYLE_PIE)
                .setLineWidth(32f)
                .build());
        int i;
        double suma = 0;
        ArrayList<Integer> listaDeIndices = obtenerIndicesDeMayorAMenor(MainActivity.cantidadesDeDatos);
        for(i = 0; i < MainActivity.cantidadesDeDatos.size(); i++)
        {
            suma += MainActivity.cantidadesDeDatos.get(i);
            listaDePorcentajes.add(0);
            listaDeIndex.add(0);
        }
        for (Integer index : listaDeIndices)
        {
            if (MainActivity.cantidadesDeDatos.get(index) != 0)
            {
                Integer porcentaje = (int) Math.round(MainActivity.cantidadesDeDatos.get(index) * 100 / suma);
                listaDePorcentajes.set(index, porcentaje);
                String nombreParaGrafico = listaDeNombresSensores.get(index) + porcentaje + "%%";
                SeriesItem seriesItem = new SeriesItem.Builder(listaDeColores.get(index))
                        .setRange(0, mSeriesMax, 0)
                        .setLineWidth(56)
                        .setCapRounded(false)
                        .setSeriesLabel(new SeriesLabel.Builder(nombreParaGrafico)
                                .setColorBack(Color.argb(218, 0, 0, 0))
                                .setColorText(listaDeColores.get(index))
                                .build())
                        .build();
                listaDeIndex.set(index, arcView.addSeries(seriesItem));
            }
        }
        Integer sumaEntera = 100;
        for (Integer index : listaDeIndices)
        {
            if (MainActivity.cantidadesDeDatos.get(index) != 0)
            {
                arcView.addEvent(new DecoEvent.Builder(sumaEntera)
                        .setIndex(listaDeIndex.get(index))
                        .setDelay(50)
                        .setDuration(1000)
                        .build());
                sumaEntera = sumaEntera - listaDePorcentajes.get(index);
            }
        }
    }

    public void inicializarGrafSensoresMB(DecoView arcView)
    {
        ArrayList<String> listaDeNombresSensores = inicializarListaDeNombresDeSensores();
        ArrayList<Integer> listaDeColores = inicializarListaDeColores();
        ArrayList<Integer> listaDeIndex = new ArrayList<Integer>();
        ArrayList<Integer> listaDePorcentajes = new ArrayList<Integer>();
        arcView.addSeries(new SeriesItem.Builder(Color.argb(120, 0, 0, 118))
                .setRange(0, mSeriesMax, mSeriesMax)
                .setChartStyle(SeriesItem.ChartStyle.STYLE_PIE)
                .setLineWidth(32f)
                .build());
        int i;
        double suma = 0;
        ArrayList<Integer> listaDeIndices = obtenerIndicesDeMayorAMenor(MainActivity.cantidadesDeDatos);
        for(i = 0; i < MainActivity.cantidadesDeDatos.size(); i++)
        {
            suma += MainActivity.cantidadesDeDatos.get(i);
            listaDePorcentajes.add(0);
            listaDeIndex.add(0);
        }
        for (Integer index : listaDeIndices)
        {
            if (MainActivity.cantidadesDeDatos.get(index) != 0)
            {
                Integer porcentaje = (int) Math.round(MainActivity.cantidadesDeDatos.get(index) * 100 / suma);
                Integer Kb = (int) Math.round(MainActivity.cantidadesDeDatos.get(index));
                listaDePorcentajes.set(index, porcentaje);
                String nombreParaGrafico = listaDeNombresSensores.get(index) + Kb + " KB";
                SeriesItem seriesItem = new SeriesItem.Builder(listaDeColores.get(index))
                        .setRange(0, mSeriesMax, 0)
                        .setLineWidth(56)
                        .setCapRounded(false)
                        .setSeriesLabel(new SeriesLabel.Builder(nombreParaGrafico)
                                .setColorBack(Color.argb(218, 0, 0, 0))
                                .setColorText(listaDeColores.get(index))
                                .build())
                        .build();
                listaDeIndex.set(index, arcView.addSeries(seriesItem));
            }
        }
        Integer sumaEntera = 100;
        for (Integer index : listaDeIndices)
        {
            if (MainActivity.cantidadesDeDatos.get(index) != 0)
            {
                arcView.addEvent(new DecoEvent.Builder(sumaEntera)
                        .setIndex(listaDeIndex.get(index))
                        .setDelay(50)
                        .setDuration(1000)
                        .build());
                sumaEntera = sumaEntera - listaDePorcentajes.get(index);
            }
        }
    }

    public ArrayList<String> inicializarListaDeNombresDeSensores()
    {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("GPS - ");
        lista.add("Acelerómetro - ");
        lista.add("Barómetro - ");
        lista.add("Giroscopio - ");
        lista.add("De Luz - ");
        return lista;
    }

    public ArrayList<Integer> inicializarListaDeColores()
    {
        ArrayList<Integer> listaDeColores = new ArrayList<Integer>();
        listaDeColores.add(Color.argb(255, 255, 51, 153));
        listaDeColores.add(Color.argb(150, 20, 255, 0));
        listaDeColores.add(Color.argb(120, 51, 255, 51));
        listaDeColores.add(Color.argb(100, 125, 125, 0));
        listaDeColores.add(Color.argb(180, 200, 200, 200));
        return listaDeColores;
    }

    public ArrayList<Integer> obtenerIndicesDeMayorAMenor(ArrayList<Integer> listanoordenada)
    {
        ArrayList<Integer> copia = new ArrayList<Integer>();
        int i;
        int j;
        for(i=0;i<listanoordenada.size();i++)
        {
            copia.add(listanoordenada.get(i));
        }
        Integer indexmayorActual = 0;
        ArrayList<Integer> listaDeIndices = new ArrayList<Integer>();
        for(i=0;i<copia.size();i++)
        {
            indexmayorActual = i;
            for(j=0;j<copia.size();j++)
            {
                if(copia.get(indexmayorActual) < copia.get(j))
                {
                    indexmayorActual = j;
                }
            }
            Log.e("AAAAAAAAAAA", indexmayorActual + "");
            listaDeIndices.add(indexmayorActual);
            copia.set(indexmayorActual,-1);
        }
        return listaDeIndices;
    }
}
