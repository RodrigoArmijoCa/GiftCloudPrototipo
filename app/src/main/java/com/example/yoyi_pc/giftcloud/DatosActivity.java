package com.example.yoyi_pc.giftcloud;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

import java.util.ArrayList;

public class DatosActivity extends AppCompatActivity
{

    final float mSeriesMax = 100f;
    static public ArrayList<Integer> cantidadesDeDatos = new ArrayList<Integer>();

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_activity);
        DecoView arcView = (DecoView)findViewById(R.id.grafSensoresUsados);
        cantidadesDeDatos.add(30);
        cantidadesDeDatos.add(30);
        cantidadesDeDatos.add(40);
        inicializarGrafSensores(arcView);
    }

    public void inicializarGrafSensores(DecoView arcView)
    {
        arcView.addSeries(new SeriesItem.Builder(Color.argb(120, 0, 0, 118))
                .setRange(0, mSeriesMax, mSeriesMax)
                .setInitialVisibility(false)
                .setLineWidth(32f)
                .build());

        SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(255, 0, 0, 255))
                .setRange(0, mSeriesMax, 0)
                .build();

        int serieGPS = arcView.addSeries(seriesItem1);

        SeriesItem seriesItem2 = new SeriesItem.Builder(Color.argb(150, 20, 255, 0))
                .setRange(0, mSeriesMax, 0)
                .build();

        int serieAcelerometro = arcView.addSeries(seriesItem2);

        SeriesItem seriesItem3 = new SeriesItem.Builder(Color.argb(120, 255, 0, 0))
                .setRange(0, mSeriesMax, 0)
                .build();

        int serieBarometro = arcView.addSeries(seriesItem3);

        arcView.addEvent(new DecoEvent.Builder(DecoEvent.EventType.EVENT_SHOW, true)
                .setDelay(100)
                .setDuration(200)
                .build());

        int i;
        double suma = 0;
        for(i = 0; i < cantidadesDeDatos.size(); i++)
            suma += cantidadesDeDatos.get(i);

        Integer porcentajeGPS = (int) Math.round(cantidadesDeDatos.get(0) * 100/suma);
        Integer porcentajeAcelerometro = (int) Math.round(cantidadesDeDatos.get(1) * 100/suma);
        Integer porcentajeBarometro = (int) Math.round(cantidadesDeDatos.get(2) * 100/suma);

        String sporGPS = "GPS - " + porcentajeGPS + "%%";
        String sporAce = "Acelerómetro - " + porcentajeAcelerometro + "%%";
        String sporBaro = "Barómetro - " + porcentajeBarometro + "%%";

        seriesItem1.setSeriesLabel(new SeriesLabel.Builder(sporGPS)
                .setColorBack(Color.argb(255, 0, 0, 255))
                .setColorText(Color.argb(255, 0, 196, 255))
                .build());

        seriesItem2.setSeriesLabel(new SeriesLabel.Builder(sporAce)
                .setColorBack(Color.argb(255, 0, 0, 0))
                .setColorText(Color.argb(150, 20, 102, 0))
                .build());

        seriesItem3.setSeriesLabel(new SeriesLabel.Builder(sporBaro)
                .setColorBack(Color.argb(255, 0, 0, 0))
                .setColorText(Color.argb(120, 255, 0, 0))
                .build());

        arcView.addEvent(new DecoEvent.Builder(porcentajeGPS)
                .setIndex(serieGPS)
                .setDelay(100)
                .setDuration(1000)
                .build());

        arcView.addEvent(new DecoEvent.Builder(porcentajeGPS+porcentajeAcelerometro)
                .setIndex(serieAcelerometro)
                .setDelay(100)
                .setDuration(1000)
                .build());

        arcView.addEvent(new DecoEvent.Builder(porcentajeGPS+porcentajeAcelerometro+porcentajeBarometro)
                .setIndex(serieBarometro)
                .setDelay(100)
                .setDuration(1000)
                .build());
    }
}
