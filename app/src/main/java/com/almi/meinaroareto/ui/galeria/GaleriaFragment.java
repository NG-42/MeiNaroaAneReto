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
import androidx.viewpager2.widget.ViewPager2;


import com.almi.meinaroareto.MainActivity;
import com.almi.meinaroareto.R;
import com.almi.meinaroareto.adaptadores.GridGaleriaAdapter;
import com.almi.meinaroareto.adaptadores.TabPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class GaleriaFragment extends Fragment {
    private GridView gvfotos;
    private String [] fotos = new String[10];
    private Context context;
    GridGaleriaAdapter gridGaleriaAdapter;
    View view;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_view_pager2,container,false);

        viewPager = root.findViewById(R.id.viewPager);
        tabLayout = root.findViewById(R.id.tabLayout);

        viewPager.setAdapter(new TabPagerAdapter((MainActivity)context));

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Interior");
                    } else if (position == 1) {
                        tab.setText("Exterior");
                    }
                }
        ).attach();
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