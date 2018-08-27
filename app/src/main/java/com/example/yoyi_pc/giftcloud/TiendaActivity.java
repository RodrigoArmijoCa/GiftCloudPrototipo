package com.example.yoyi_pc.giftcloud;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class TiendaActivity extends AppCompatActivity implements TiendaFragment.OnFragmentInteractionListener{

    static ArrayList<String> listaDeNomPesta = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
        iniciaNombrePesta();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayoutTienda);
        configTabs(tabLayout, listaDeNomPesta.size(), listaDeNomPesta);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pagerTienda);
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

    public void configTabs(TabLayout tab, int numTabs, ArrayList<String> lista)
    {
        for(int i=0; i<numTabs; i++)
        {
            tab.addTab(tab.newTab().setText(lista.get(i)));
        }
        tab.setTabGravity(tab.GRAVITY_FILL);
    }

    public void iniciaNombrePesta()
    {
        listaDeNomPesta.add("Nuevos");
        listaDeNomPesta.add("Los mas vendidos");
        listaDeNomPesta.add("Los mejores evaluados");
    }

    public void confAdaptadorPag(PageAdapter adap, int cant)
    {
        for(int i=0; i<cant; i++)
        {
            adap.addFragment(newInstance(i));
        }
    }

    public TiendaFragment newInstance(int index)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        TiendaFragment nuevo = new TiendaFragment();
        nuevo.setArguments(bundle);
        return nuevo;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
