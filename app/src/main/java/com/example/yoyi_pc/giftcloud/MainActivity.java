package com.example.yoyi_pc.giftcloud;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements fragmentoPesta.OnFragmentInteractionListener, fragmentoIndi.OnFragmentInteractionListener{

    static ArrayList<String> listaDeNomPesta = new ArrayList<String>();
    static ArrayList<ArrayList<String>> listaDeNomSubPesta  = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<ArrayList<Mision>>> listaDeContSubPesta  = new ArrayList<ArrayList<ArrayList<Mision>>>();
    static ArrayList<ArrayList<ArrayList<Mision>>> listaMiniMisiones = new ArrayList<ArrayList<ArrayList<Mision>>>();
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    static public ActionBar barritaSuperior;
    static public View vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        barritaSuperior = getSupportActionBar();
        vista = getSupportActionBar().getCustomView();
        setContentView(R.layout.activity_main);
        dl = (DrawerLayout) findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.bringToFront();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.perfil)
                {
                    Toast.makeText(MainActivity.this, "Mi perfil", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.datos)
                {
                    Intent nuevoIntent = new Intent(MainActivity.this, DatosActivity.class);
                    startActivity(nuevoIntent);
                }
                else if(id == R.id.tienda)
                {
                    Toast.makeText(MainActivity.this, "Tienda", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
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
        listaDeNomPesta.add("Sensores");
        listaDeNomPesta.add("Por objetivos");
        listaDeNomPesta.add("Por tipo de empresa");
    }

    public void iniciaNombreSubPesta()
    {
        ArrayList<String> nuevo = new ArrayList<String>();
        nuevo.add("Acelerometro");
        nuevo.add("Barometro");
        nuevo.add("De Luz");
        listaDeNomSubPesta.add(nuevo);
        ArrayList<String> nuevo1 = new ArrayList<String>();
        nuevo1.add("SFDL");
        nuevo1.add("CFDL");
        nuevo1.add("Otro");
        listaDeNomSubPesta.add(nuevo1);
        ArrayList<String> nuevo2 = new ArrayList<String>();
        nuevo2.add("Social");
        nuevo2.add("Marketing");
        nuevo2.add("Publicidad Dirigida");
        listaDeNomSubPesta.add(nuevo2);
    }

    public void iniciaContSubPesta()
    {
        ArrayList<ArrayList<Mision>> primera = new ArrayList<ArrayList<Mision>>();
        ArrayList<Mision> anuevo = new ArrayList<Mision>();
        Mision amision11 = new Mision(1,"Estudio de Sismos", "La escuela de psicología de la Universidad de Santiago de Chile requiere del estudio del flujo cotidiano del personal estudiantil, con el objetivo de estudiar ubicaciones para la instalación de maquinas recreativas que tengan como el objetivo aliviar el estres del personal, para lo cual se le solicita el dato de posición en GPS por cada hora entre las 8:00 y 19:00 hrs, durante una semana.", "psico", "Escuela de Psicología de la Universidad de Santiago de Chile", "Estudio de rutas del estudiantado", "GPS");
        Mision amision12 = new Mision(2, "Estudio de Sismos", "El centro sismológico nacional requiere de información de acceleremotros de smartphones con el fin de evaluar la predición de sismos en tiempos razonables, que tengan como objetivo alertar a la población", "csn", "CSN", "Estudio de sismos", "Acelerometro, GPS");
        Mision amision13 = new Mision(3, "Predicción de tormentas", "La Dirección Meteorológica de Chile tiene el objetivo de realizar estudios que tengan como fin una mejorar la planificación para la construcción de calles ante tormentas y lluvias, para lo cual necesitan estudiar los comportamientos de la presión atmosférica durante todo un año, para lo cual por la Dirección Meteorológica de Chile le solicita poder recabar información del barómetro de su smartphone, una vez al dia por 2 semanas.", "dmc", "Dirección Meteorológica de Chile", "Estudio de lluvias y tormentas en Santiago", "Barómetro, GPS");
        anuevo.add(amision11);
        anuevo.add(amision12);
        anuevo.add(amision13);
        primera.add(anuevo);
        ArrayList<Mision> anuevo1 = new ArrayList<Mision>();
        Mision amision21 = new Mision(4, "NombreMision1Tipo2Pestana1", "DescripcionMision1Tipo2Pestana1", "logoempresa");
        Mision amision22 = new Mision(5,"NombreMision2Tipo2Pestana1", "DescripcionMision2Tipo2Pestana1", "logoempresa");
        Mision amision23 = new Mision(6,"NombreMision3Tipo2Pestana1", "DescripcionMision3Tipo2Pestana1", "logoempresa");
        anuevo1.add(amision21);
        anuevo1.add(amision22);
        anuevo1.add(amision23);
        primera.add(anuevo1);
        ArrayList<Mision> anuevo2 = new ArrayList<Mision>();
        Mision amision31 = new Mision(7,"NombreMision1Tipo3Pestana1", "DescripcionMision1Tipo3Pestana1", "logoempresa");
        Mision amision32 = new Mision(8,"NombreMision2Tipo3Pestana1", "DescripcionMision2Tipo3Pestana1", "logoempresa");
        Mision amision33 = new Mision(9,"NombreMision3Tipo3Pestana1", "DescripcionMision3Tipo3Pestana1", "logoempresa");
        anuevo2.add(amision31);
        anuevo2.add(amision32);
        anuevo2.add(amision33);
        primera.add(anuevo2);
        listaDeContSubPesta.add(primera);
        ArrayList<ArrayList<Mision>> segunda = new ArrayList<ArrayList<Mision>>();
        ArrayList<Mision> bnuevo = new ArrayList<Mision>();
        Mision bmision11 = new Mision(10,"NombreMision1Tipo1Pestana2", "DescripcionMision1Tipo1Pestana2", "logoempresa");
        Mision bmision12 = new Mision(11,"NombreMision2Tipo1Pestana2", "DescripcionMision2Tipo1Pestana2", "logoempresa");
        Mision bmision13 = new Mision(12,"NombreMision3Tipo1Pestana2", "DescripcionMision3Tipo1Pestana2", "logoempresa");
        bnuevo.add(bmision11);
        bnuevo.add(bmision12);
        bnuevo.add(bmision13);
        segunda.add(bnuevo);
        ArrayList<Mision> bnuevo1 = new ArrayList<Mision>();
        Mision bmision21 = new Mision(13,"NombreMision1Tipo2Pestana2", "DescripcionMision1Tipo2Pestana2", "logoempresa");
        Mision bmision22 = new Mision(14,"NombreMision2Tipo2Pestana2", "DescripcionMision2Tipo2Pestana2", "logoempresa");
        Mision bmision23 = new Mision(15,"NombreMision3Tipo2Pestana2", "DescripcionMision3Tipo2Pestana2", "logoempresa");
        bnuevo1.add(bmision21);
        bnuevo1.add(bmision22);
        bnuevo1.add(bmision23);
        segunda.add(bnuevo1);
        ArrayList<Mision> bnuevo2 = new ArrayList<Mision>();
        Mision bmision31 = new Mision(16,"NombreMision1Tipo3Pestana2", "DescripcionMision1Tipo3Pestana2", "logoempresa");
        Mision bmision32 = new Mision(17,"NombreMision2Tipo3Pestana2", "DescripcionMision2Tipo3Pestana2", "logoempresa");
        Mision bmision33 = new Mision(18,"NombreMision3Tipo3Pestana2", "DescripcionMision3Tipo3Pestana2", "logoempresa");
        bnuevo2.add(bmision31);
        bnuevo2.add(bmision32);
        bnuevo2.add(bmision33);
        segunda.add(bnuevo2);
        listaDeContSubPesta.add(segunda);
        ArrayList<ArrayList<Mision>> tercera = new ArrayList<ArrayList<Mision>>();
        ArrayList<Mision> cnuevo = new ArrayList<Mision>();
        Mision cmision11 = new Mision(19,"NombreMision1Tipo1Pestana3", "DescripcionMision1Tipo1Pestana3", "logoempresa");
        Mision cmision12 = new Mision(20,"NombreMision2Tipo1Pestana3", "DescripcionMision2Tipo1Pestana3", "logoempresa");
        Mision cmision13 = new Mision(21,"NombreMision3Tipo1Pestana3", "DescripcionMision3Tipo1Pestana3", "logoempresa");
        cnuevo.add(cmision11);
        cnuevo.add(cmision12);
        cnuevo.add(cmision13);
        tercera.add(cnuevo);
        ArrayList<Mision> cnuevo1 = new ArrayList<Mision>();
        Mision cmision21 = new Mision(22,"NombreMision1Tipo2Pestana3", "DescripcionMision1Tipo2Pestana3", "logoempresa");
        Mision cmision22 = new Mision(23,"NombreMision2Tipo2Pestana3", "DescripcionMision2Tipo2Pestana3", "logoempresa");
        Mision cmision23 = new Mision(24,"NombreMision3Tipo2Pestana3", "DescripcionMision3Tipo2Pestana3", "logoempresa");
        cnuevo1.add(cmision21);
        cnuevo1.add(cmision22);
        cnuevo1.add(cmision23);
        tercera.add(cnuevo1);
        ArrayList<Mision> cnuevo2 = new ArrayList<Mision>();
        Mision cmision31 = new Mision(25,"NombreMision1Tipo3Pestana3", "DescripcionMision1Tipo3Pestana3", "logoempresa");
        Mision cmision32 = new Mision(26,"NombreMision2Tipo3Pestana3", "DescripcionMision2Tipo3Pestana3", "logoempresa");
        Mision cmision33 = new Mision(27,"NombreMision3Tipo3Pestana3", "DescripcionMision3Tipo3Pestana3", "logoempresa");
        cnuevo2.add(cmision31);
        cnuevo2.add(cmision32);
        cnuevo2.add(cmision33);
        tercera.add(cnuevo2);
        listaDeContSubPesta.add(tercera);
    }


}

