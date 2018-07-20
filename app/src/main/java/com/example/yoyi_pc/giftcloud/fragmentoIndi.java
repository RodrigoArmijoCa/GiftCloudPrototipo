package com.example.yoyi_pc.giftcloud;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
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
    private Handler handler = new Handler();
    private View fishqlo;

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
        ArrayList<ArrayList<Mision>> lista = MainActivity.listaDeContSubPesta.get(indexPadre);
        final ArrayList<Mision> lista1 = lista.get(indexHijo);
        final ListView lv = vista.findViewById(R.id.listadeelementos);
        fishqlo = vista;
        final AdaptadorListView adapter = new AdaptadorListView(getActivity(), lista1);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(lista1.get(i).isSelected)
                {
                    lista1.get(i).setSelected(false);
                    lista1.get(i).setARealizar(false);
                }
                else
                {
                    lista1.get(i).setSelected(true);
                    lista1.get(i).setARealizar(true);
                }
                adapter.updateRecords(lista1);
        }});
        Button boton = vista.findViewById(R.id.botonHacerMision);
        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for(int j=0; j<lista1.size(); j++)
                {
                    if(lista1.get(j).getARealizar())
                    {
                        final int mayo = j;
                        new Thread(new Runnable()
                        {
                            public void run()
                            {

                                View vista = getViewByPosition(mayo, lv);
                                final ProgressBar progressBar = vista.findViewById(R.id.progressBar);
                                final TextView misionCompletada = vista.findViewById(R.id.misionCompletada);
                                handler.post(new Runnable()
                                {
                                    public void run()
                                    {
                                        progressBar.setVisibility(View.VISIBLE);
                                    }
                                });
                                for(int k=1; k<=100; k++)
                                {

                                    final int mayo = k;
                                    handler.post(new Runnable()
                                {
                                    public void run()
                                    {
                                        progressBar.setProgress(mayo);
                                    }
                                });
                                    try
                                    {
                                        Thread.sleep(10);
                                    }
                                    catch (InterruptedException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                                handler.post(new Runnable()
                                {
                                    public void run()
                                    {
                                        progressBar.setVisibility(View.INVISIBLE);
                                    }
                                });
                                handler.post(new Runnable()
                                {
                                    public void run()
                                    {
                                        misionCompletada.setVisibility(View.VISIBLE);
                                    }
                                });

                            }
                        }).start();

                }
                }
            }
        });
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
//            {
//                final int pos = position;
//                Intent intent = new Intent(getContext(), perfilMisionActivity.class);
//                Mision misionElegida = listaDeMisiones.get(pos);
//                String nombreMision = misionElegida.getNombre();
//                String descripcionMision = misionElegida.getDescripcion();
//                String nombreImagen = misionElegida.getNombreImagen();
//                Bundle bundle = new Bundle();
//                bundle.putString("nombre", nombreMision);
//                bundle.putString("descripcion", descripcionMision);
//                bundle.putString("nombreImagen", nombreImagen);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });
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

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }


}
