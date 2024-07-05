package com.almi.meinaroareto.ui.galeria;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.almi.meinaroareto.R;
import com.almi.meinaroareto.adaptadores.GridGaleriaAdapter;


public class GaleriaFragment2 extends Fragment {
    private GridView gvfotos;
    private String [] fotos = new String[10];
    private Context context;
    GridGaleriaAdapter gridGaleriaAdapter;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_galeria,container,false);
        fotos[0]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
        fotos[1]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
        fotos[2]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
        fotos[3]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
        fotos[4]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
        fotos[5]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
        fotos[6]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
        fotos[7]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
        fotos[8]="https://www.elcorreo.com/content-local/wp-content/uploads/sites/10/2024/04/almi-ppal.jpg";
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