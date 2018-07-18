package com.example.yoyi_pc.giftcloud;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragmentoPesta.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragmentoPesta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoPesta extends Fragment implements fragmentoIndi.OnFragmentInteractionListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public fragmentoPesta() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vista = inflater.inflate(R.layout.fragment_fragmento_pesta, container, false);
        TabLayout tabLayout = (TabLayout) vista.findViewById(R.id.tablayoutpest);
        int index = 0;
        if (getArguments() != null)
        {
           index = getArguments().getInt("index");
        }
        confNombreSubPesta(tabLayout, index);
        final ViewPager viewPager = (ViewPager) vista.findViewById(R.id.pagerpest);
        final PageAdapter adapter = new PageAdapter(getChildFragmentManager());
        ArrayList<String> nombres = MainActivity.listaDeNomSubPesta.get(index);
        confAdaptadorPag(adapter, nombres.size(), index);
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
        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void confAdaptadorPag(PageAdapter adap, int cant, int index)
    {
        for(int i=0; i<cant; i++)
        {
            adap.addFragment(newInstance(index, i));
        }
    }

    public fragmentoIndi newInstance(int indexPadre, int indexHijo)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("indexPadre", indexPadre);
        bundle.putInt("indexHijo", indexHijo);
        fragmentoIndi nuevo = new fragmentoIndi();
        nuevo.setArguments(bundle);
        return nuevo;
    }

    public void confNombreSubPesta(TabLayout tab, int index)
    {
        ArrayList<String> nombres = MainActivity.listaDeNomSubPesta.get(index);
        for(int i=0; i<nombres.size(); i++)
        {
            tab.addTab(tab.newTab().setText(nombres.get(i)));
        }
        tab.setTabGravity(tab.GRAVITY_FILL);
    }
}
