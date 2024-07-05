package com.almi.meinaroareto.adaptadores;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.almi.meinaroareto.R;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.squareup.picasso.Picasso;

public class GridGaleriaAdapter extends BaseAdapter {
    private Context context;
    private String[] fotos;

    public GridGaleriaAdapter(Context context, String[] fotos) {
        this.context = context;
        this.fotos = fotos;
    }

    @Override
    public int getCount() {
        return fotos.length;
    }

    @Override
    public Object getItem(int position) {
        return fotos[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return vistaPersonalizada(position, convertView, parent);
    }

    public View vistaPersonalizada(int position, View convertView, ViewGroup parent) {
        // Instanciamos El Cargador De La Vista
        LayoutInflater cargador = LayoutInflater.from(this.context);
        // Cargamos La Vista
        View fila = cargador.inflate(R.layout.item_grid_adapter, null);
        // Accedemos A La Imagen De La Vista Personalizada
        ImageView imagen = fila.findViewById(R.id.ivGridAdapter);
        Picasso.with(this.context)
                .load(fotos[position])
                .into(imagen);

        // Agregar OnClickListener a la imagen
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un diálogo para mostrar la imagen ampliada
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_image_zoom);
                ImageView imageView = dialog.findViewById(R.id.imageView);
                Picasso.with(context)
                        .load(fotos[position])
                        .into(imageView);
                dialog.show();
            }
        });

        return fila;
    }
}
