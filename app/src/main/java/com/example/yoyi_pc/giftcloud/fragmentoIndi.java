package com.example.yoyi_pc.giftcloud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragmentoIndi.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragmentoIndi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentoIndi extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public fragmentoIndi() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentoIndi.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentoIndi newInstance(String param1, String param2) {
        fragmentoIndi fragment = new fragmentoIndi();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View vista = inflater.inflate(R.layout.fragment_fragmento_indi, container, false);
        int indexPadre = -1;
        int indexHijo = -1;
        if (getArguments() != null)
        {
            indexPadre = getArguments().getInt("indexPadre");
            indexHijo = getArguments().getInt("indexHijo");
        }

        TextView mayorin = vista.findViewById(R.id.mayorin);
        String csm = "Num: " + indexPadre + "-" + indexHijo;
        mayorin.setText(csm);

        ArrayList<ArrayList<Mision>> lista = MainActivity.listaDeContSubPesta.get(indexPadre);
        ArrayList<Mision> lista1 = lista.get(indexHijo);
        ListView lv = (ListView) vista.findViewById(R.id.listadeelementos);
        AdaptadorListView adapter = new AdaptadorListView(getActivity(), lista1);
        lv.setAdapter(adapter);
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
}
