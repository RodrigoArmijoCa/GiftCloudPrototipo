package com.example.yoyi_pc.giftcloud;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yoyi-PC on 26-08-2018.
 */

public class AdaptadorTienda extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Producto> items;

    public AdaptadorTienda (Activity activity, ArrayList<Producto> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Producto> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void updateRecords(ArrayList<Producto> users){
        this.items = users;

        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.elementolistatiendalayout, null);
        }

        Producto dir = items.get(position);

        TextView nombreProducto = (TextView) v.findViewById(R.id.nombreProducto);
        TextView descripcionProducto = (TextView) v.findViewById(R.id.descripcionProducto);
        TextView precioProducto = (TextView) v.findViewById(R.id.precioProducto);
        nombreProducto.setText(dir.getNombre());
        descripcionProducto.setText(dir.getDescripcion());
        String precio = dir.getPrecio() + "";
        precioProducto.setText(precio);
        ImageView imagen = (ImageView) v.findViewById(R.id.imagenProducto);
        Context context = imagen.getContext();
        int id = context.getResources().getIdentifier(dir.getNombreImagenProducto(), "drawable", context.getPackageName());
        imagen.setImageResource(id);
        return v;
    }
}

