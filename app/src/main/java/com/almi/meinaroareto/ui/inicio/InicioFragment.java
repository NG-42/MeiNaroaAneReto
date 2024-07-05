package com.almi.meinaroareto.ui.inicio;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.almi.meinaroareto.R;
import com.almi.meinaroareto.adaptadores.CursosAdapter;
import com.almi.meinaroareto.datos.Curso;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InicioFragment extends Fragment {

    private ArrayList<Curso> cursos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lvCursos = view.findViewById(R.id.lvCursos);
        obtenerCursos(lvCursos);
    }

    private void obtenerCursos(final ListView lvCursos) {
        Context context = getContext();
        if (context != null) {
            ApiData(context, new ApiDataCallback() {
                @Override
                public void onSuccess(ArrayList<Curso> cursosObtenidos) {
                    cursos.clear();
                    cursos.addAll(cursosObtenidos);
                    CursosAdapter adapter = new CursosAdapter(context, cursos);
                    lvCursos.setAdapter(adapter);
                    Log.d("obtenerCursos", "Cursos asignados al adaptador");
                }

                @Override
                public void onError(Exception e) {
                    Toast.makeText(context, "Error al obtener cursos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void ApiData(Context context, final ApiDataCallback callback) {
        String urlConsultaTarjeta = "http://100.29.137.108:8000/ws/lanbide";  // Asegúrate de usar la URL correcta de tu API

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlConsultaTarjeta, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("ApiData Response", response);
                try {
                    JSONArray jsonResponse = new JSONArray(response);
                    ArrayList<Curso> cursos = new ArrayList<>();
                    for (int i = 0; i < jsonResponse.length(); i++) {
                        JSONObject cursoJson = jsonResponse.getJSONObject(i);
                        String nombre = cursoJson.getString("nombre");
                        Log.d("Curso", "Nombre: " + nombre);  // Agrega este log para verificar que los nombres se están obteniendo
                        cursos.add(new Curso(nombre));
                    }
                    callback.onSuccess(cursos);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("ApiData Error", e.toString());
                    callback.onError(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("ApiData Error", volleyError.toString());
                callback.onError(volleyError);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);  // No es necesario el casting
    }

    public interface ApiDataCallback {
        void onSuccess(ArrayList<Curso> cursos);
        void onError(Exception e);
    }
}
