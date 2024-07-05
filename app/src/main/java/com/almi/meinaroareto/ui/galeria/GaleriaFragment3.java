package com.almi.meinaroareto.ui.galeria;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.almi.meinaroareto.R;
import com.almi.meinaroareto.adaptadores.GridGaleriaAdapter;


public class GaleriaFragment3 extends Fragment {
    private GridView gvfotos;
    private String [] fotos = new String[10];
    private Context context;
    GridGaleriaAdapter gridGaleriaAdapter;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_galeria,container,false);
        fotos[0]="https://almi.eus/wp-content/uploads/2016/09/02-Entrada-Almi-1024x576.jpg";
        fotos[1]="https://almi.eus/wp-content/uploads/2016/09/03-Entrada-Almi-1024x576.jpg";
        fotos[2]="https://almi.eus/wp-content/uploads/2016/09/04-Entrada-Almi-1024x576.jpg";
        fotos[3]="https://almi.eus/wp-content/uploads/2016/09/06-Aula-Ordenadores-1024x576.jpg";
        fotos[4]="https://almi.eus/wp-content/uploads/2016/09/08-Aula-de-ordenadores-1024x576.jpg";
        fotos[5]="https://almi.eus/wp-content/uploads/2016/09/09-Clase-en-Almi-1024x576.jpg";
        fotos[6]="https://almi.eus/wp-content/uploads/2016/09/11Trabajos-en-grupo-1024x576.jpg";
        fotos[7]="https://almi.eus/wp-content/uploads/2016/05/historia2-1.png";
        fotos[8]="https://almi.eus/wp-content/uploads/2018/06/Ethazi-1024x768.jpg";
        //Accedemos Al GridView
        gvfotos= root.findViewById(R.id.gvfotos);
        //Creamos Un Nuevo Adaptador Fon Las Fotos Que Hemos Intruducido
        GridGaleriaAdapter adapter=new GridGaleriaAdapter(context,fotos);
        //Asignamos El Adaptador Al GridView
        gvfotos.setAdapter(adapter);
        return root;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}