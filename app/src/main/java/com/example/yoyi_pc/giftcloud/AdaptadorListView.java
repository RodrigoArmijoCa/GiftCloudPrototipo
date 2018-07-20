package com.example.yoyi_pc.giftcloud;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorListView extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Mision> items;

    public AdaptadorListView (Activity activity, ArrayList<Mision> items) {
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

    public void addAll(ArrayList<Mision> category) {
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

    public void updateRecords(ArrayList<Mision> users){
        this.items = users;

        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.elementolistamisi, null);
        }

        Mision dir = items.get(position);

        TextView title = (TextView) v.findViewById(R.id.nombre);
        title.setText(dir.getNombre());

        TextView description = (TextView) v.findViewById(R.id.descripcion);
        description.setText(dir.getDescripcion());

        ImageView imagen = (ImageView) v.findViewById(R.id.imagen);
        Context context = imagen.getContext();
        int id = context.getResources().getIdentifier(dir.getNombreImagen(), "drawable", context.getPackageName());
        imagen.setImageResource(id);

        ImageView boton = v.findViewById(R.id.boton);
        if(dir.isSelected())
            boton.setBackgroundResource(R.drawable.checked);
        else
        {
            boton.setBackgroundResource(R.drawable.check);
        }

        return v;
    }
}
