package com.almi.meinaroareto.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.almi.meinaroareto.R;
import com.almi.meinaroareto.datos.Curso;

import java.util.ArrayList;

public class CursosAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Curso> grados;

    public CursosAdapter(Context context, ArrayList<Curso> grados) {
        this.context = context;
        this.grados = grados;
    }

    @Override
    public int getCount() {
        return grados.size();
    }

    @Override
    public Object getItem(int position) {
        return grados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return vistaPersonalizada(position,  convertView,  parent);
    }


    public View vistaPersonalizada(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View linea = inflater.inflate(R.layout.curso_item_adapter,null);
        TextView nombre = linea.findViewById(R.id.txtNombreGrado);
        nombre.setText(grados.get(position).getNombre());
        return linea;


    }
}
