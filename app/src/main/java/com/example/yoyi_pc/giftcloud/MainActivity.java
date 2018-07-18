package com.example.yoyi_pc.giftcloud;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements fragmentoPesta.OnFragmentInteractionListener, fragmentoIndi.OnFragmentInteractionListener{

    static ArrayList<String> listaDeNomPesta = new ArrayList<String>();
    static ArrayList<ArrayList<String>> listaDeNomSubPesta  = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<ArrayList<Mision>>> listaDeContSubPesta  = new ArrayList<ArrayList<ArrayList<Mision>>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciaNombrePesta();
        iniciaNombreSubPesta();
        iniciaContSubPesta();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        configTabs(tabLayout, listaDeNomPesta.size(), listaDeNomPesta);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        confAdaptadorPag(adapter, listaDeNomPesta.size());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void configTabs(TabLayout tab, int numTabs, ArrayList<String> lista)
    {
        for(int i=0; i<numTabs; i++)
        {
            tab.addTab(tab.newTab().setText(lista.get(i)));
        }
        tab.setTabGravity(tab.GRAVITY_FILL);
    }

    public void confAdaptadorPag(PageAdapter adap, int cant)
    {
        for(int i=0; i<cant; i++)
        {
            adap.addFragment(newInstance(i));
        }
    }

    public fragmentoPesta newInstance(int index)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragmentoPesta nuevo = new fragmentoPesta();
        nuevo.setArguments(bundle);
        return nuevo;
    }

    public void iniciaNombrePesta()
    {
        listaDeNomPesta.add("Por objetivos");
        listaDeNomPesta.add("Por tipo de empresa");
        listaDeNomPesta.add("Sensores");
    }

    public void iniciaNombreSubPesta()
    {
        ArrayList<String> nuevo = new ArrayList<String>();
        nuevo.add("Social");
        nuevo.add("Marketing");
        nuevo.add("Publicidad Dirigida");
        listaDeNomSubPesta.add(nuevo);
        ArrayList<String> nuevo1 = new ArrayList<String>();
        nuevo1.add("SFDL");
        nuevo1.add("CFDL");
        nuevo1.add("Otro");
        listaDeNomSubPesta.add(nuevo1);
        ArrayList<String> nuevo2 = new ArrayList<String>();
        nuevo2.add("Acelerometro");
        nuevo2.add("Barometro");
        nuevo2.add("De Luz");
        listaDeNomSubPesta.add(nuevo2);
    }

    public void iniciaContSubPesta()
    {
        ArrayList<ArrayList<Mision>> primera = new ArrayList<ArrayList<Mision>>();
        ArrayList<Mision> anuevo = new ArrayList<Mision>();
        Mision amision11 = new Mision("NombreMision1Tipo1Pestana1", "DescripcionMision1Tipo1Pestana1");
        Mision amision12 = new Mision("NombreMision2Tipo1Pestana1", "DescripcionMision2Tipo1Pestana1");
        Mision amision13 = new Mision("NombreMision3Tipo1Pestana1", "DescripcionMision3Tipo1Pestana1");
        anuevo.add(amision11);
        anuevo.add(amision12);
        anuevo.add(amision13);
        primera.add(anuevo);
        ArrayList<Mision> anuevo1 = new ArrayList<Mision>();
        Mision amision21 = new Mision("NombreMision1Tipo2Pestana1", "DescripcionMision1Tipo2Pestana1");
        Mision amision22 = new Mision("NombreMision2Tipo2Pestana1", "DescripcionMision2Tipo2Pestana1");
        Mision amision23 = new Mision("NombreMision3Tipo2Pestana1", "DescripcionMision3Tipo2Pestana1");
        anuevo1.add(amision21);
        anuevo1.add(amision22);
        anuevo1.add(amision23);
        primera.add(anuevo1);
        ArrayList<Mision> anuevo2 = new ArrayList<Mision>();
        Mision amision31 = new Mision("NombreMision1Tipo3Pestana1", "DescripcionMision1Tipo3Pestana1");
        Mision amision32 = new Mision("NombreMision2Tipo3Pestana1", "DescripcionMision2Tipo3Pestana1");
        Mision amision33 = new Mision("NombreMision3Tipo3Pestana1", "DescripcionMision3Tipo3Pestana1");
        anuevo2.add(amision31);
        anuevo2.add(amision32);
        anuevo2.add(amision33);
        primera.add(anuevo2);
        listaDeContSubPesta.add(primera);
        ArrayList<ArrayList<Mision>> segunda = new ArrayList<ArrayList<Mision>>();
        ArrayList<Mision> bnuevo = new ArrayList<Mision>();
        Mision bmision11 = new Mision("NombreMision1Tipo1Pestana2", "DescripcionMision1Tipo1Pestana2");
        Mision bmision12 = new Mision("NombreMision2Tipo1Pestana2", "DescripcionMision2Tipo1Pestana2");
        Mision bmision13 = new Mision("NombreMision3Tipo1Pestana2", "DescripcionMision3Tipo1Pestana2");
        bnuevo.add(bmision11);
        bnuevo.add(bmision12);
        bnuevo.add(bmision13);
        segunda.add(bnuevo);
        ArrayList<Mision> bnuevo1 = new ArrayList<Mision>();
        Mision bmision21 = new Mision("NombreMision1Tipo2Pestana2", "DescripcionMision1Tipo2Pestana2");
        Mision bmision22 = new Mision("NombreMision2Tipo2Pestana2", "DescripcionMision2Tipo2Pestana2");
        Mision bmision23 = new Mision("NombreMision3Tipo2Pestana2", "DescripcionMision3Tipo2Pestana2");
        bnuevo1.add(bmision21);
        bnuevo1.add(bmision22);
        bnuevo1.add(bmision23);
        segunda.add(bnuevo1);
        ArrayList<Mision> bnuevo2 = new ArrayList<Mision>();
        Mision bmision31 = new Mision("NombreMision1Tipo3Pestana2", "DescripcionMision1Tipo3Pestana2");
        Mision bmision32 = new Mision("NombreMision2Tipo3Pestana2", "DescripcionMision2Tipo3Pestana2");
        Mision bmision33 = new Mision("NombreMision3Tipo3Pestana2", "DescripcionMision3Tipo3Pestana2");
        bnuevo2.add(bmision31);
        bnuevo2.add(bmision32);
        bnuevo2.add(bmision33);
        segunda.add(bnuevo2);
        listaDeContSubPesta.add(segunda);
        ArrayList<ArrayList<Mision>> tercera = new ArrayList<ArrayList<Mision>>();
        ArrayList<Mision> cnuevo = new ArrayList<Mision>();
        Mision cmision11 = new Mision("NombreMision1Tipo1Pestana3", "DescripcionMision1Tipo1Pestana3");
        Mision cmision12 = new Mision("NombreMision2Tipo1Pestana3", "DescripcionMision2Tipo1Pestana3");
        Mision cmision13 = new Mision("NombreMision3Tipo1Pestana3", "DescripcionMision3Tipo1Pestana3");
        cnuevo.add(cmision11);
        cnuevo.add(cmision12);
        cnuevo.add(cmision13);
        tercera.add(cnuevo);
        ArrayList<Mision> cnuevo1 = new ArrayList<Mision>();
        Mision cmision21 = new Mision("NombreMision1Tipo2Pestana3", "DescripcionMision1Tipo2Pestana3");
        Mision cmision22 = new Mision("NombreMision2Tipo2Pestana3", "DescripcionMision2Tipo2Pestana3");
        Mision cmision23 = new Mision("NombreMision3Tipo2Pestana3", "DescripcionMision3Tipo2Pestana3");
        cnuevo1.add(cmision21);
        cnuevo1.add(cmision22);
        cnuevo1.add(cmision23);
        tercera.add(cnuevo1);
        ArrayList<Mision> cnuevo2 = new ArrayList<Mision>();
        Mision cmision31 = new Mision("NombreMision1Tipo3Pestana3", "DescripcionMision1Tipo3Pestana3");
        Mision cmision32 = new Mision("NombreMision2Tipo3Pestana3", "DescripcionMision2Tipo3Pestana3");
        Mision cmision33 = new Mision("NombreMision3Tipo3Pestana3", "DescripcionMision3Tipo3Pestana3");
        cnuevo2.add(cmision31);
        cnuevo2.add(cmision32);
        cnuevo2.add(cmision33);
        tercera.add(cnuevo2);
        listaDeContSubPesta.add(tercera);
    }


}

