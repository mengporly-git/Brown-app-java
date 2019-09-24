package com.example.browncoffee.screen.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.MenuAdapter;
import com.example.browncoffee.model.MenuModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CakeFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("ROYAL CHOCOLATE", "$2.85", "", "", R.drawable.royal_chocolate),
            new MenuModel("STRAWBERRY CAKE", "$2.85", "", "", R.drawable.strawberry_cake),
            new MenuModel("BROWNIE", "$2.25", "", "", R.drawable.brownie),
            new MenuModel("TIRAMISU", "$2.85", "", "", R.drawable.tiramisu),
            new MenuModel("OPERA CAKE", "$2.85", "", "", R.drawable.opera_cake),
            new MenuModel("CARROT CAKE", "$2.50", "", "", R.drawable.carrot_cake),
            new MenuModel("GREEN TEA RED BEAN ROLL", "$2.85", "", "", R.drawable.green_tea_red_bean_roll),
            new MenuModel("BLACK FOREST", "$2.85", "", "", R.drawable.black_forest),
            new MenuModel("THREE CHOCOLATE", "$2.85", "", "", R.drawable.three_chocolate),
            new MenuModel("BROWN CHEESE CAKE", "$2.85", "", "", R.drawable.brown_cheese_cake),
            new MenuModel("BANANA BREAD", "$1.75", "", "", R.drawable.banana_bread),
            new MenuModel("SNOW QUEEN", "$2.85", "", "", R.drawable.snow_queen)

    ));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cake, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
