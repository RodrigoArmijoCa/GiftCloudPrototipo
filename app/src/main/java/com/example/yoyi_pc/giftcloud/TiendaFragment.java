package com.example.yoyi_pc.giftcloud;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TiendaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TiendaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TiendaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TiendaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TiendaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TiendaFragment newInstance(String param1, String param2) {
        TiendaFragment fragment = new TiendaFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_tienda, container, false);
        Producto producto1 = new Producto("Batería Externa Sony 5.800mAh Negra", "Diseño compacto y ligero te permitirá llevarla contigo a donde quiera que vayas con una capacidad de 5.800 mAh de intensidad.", "bateriaexterna", 12);
        Producto producto2 = new Producto("Asistente de voz Wifi Alexa Echo (2da Generación)", "Echo (2nd Gen) tiene un nuevo parlante, un nuevo diseño. Echo se conecta a Alexa para reproducir música, realizar llamadas, configurar alarmas y temporizadores de música, hacer preguntas, controlar dispositivos domésticos inteligentes y mucho más, al instante.", "alexa", 120);
        Producto producto3 = new Producto("Carga BIP de $4000", "Carga un saldo de $4000 en la tarjeta de BIP que tengas enlazada a tu cuenta de GiftCloud", "cargabip4000", 14);
        final ArrayList<Producto> lista = new ArrayList<Producto>();
        lista.add(producto1);
        lista.add(producto2);
        lista.add(producto3);
        final ListView lv = vista.findViewById(R.id.listadeelementostienda);
        final AdaptadorTienda adapter = new AdaptadorTienda(getActivity(), lista);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int pos, long id) {
                Intent intent = new Intent(getContext(), PerfilProductoActivity.class);
                Producto productoSeleccionado = lista.get(pos);
                String nombreProducto = productoSeleccionado.getNombre();
                String descripcionProducto = productoSeleccionado.getDescripcion();
                String nombreImagen = productoSeleccionado.getNombreImagenProducto();
                Integer precio = productoSeleccionado.getPrecio();
                String strprecio = precio + "";
                Bundle bundle = new Bundle();
                bundle.putString("nombre", nombreProducto);
                bundle.putString("descripcion", descripcionProducto);
                bundle.putString("nombreImagen", nombreImagen);
                bundle.putString("strprecio", strprecio);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
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
