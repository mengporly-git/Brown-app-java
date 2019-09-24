package com.example.browncoffee.screen.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.MenuAdapter;
import com.example.browncoffee.model.MenuModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HotDrinkFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("VANILLA LATTE", "$2.50", "$3.35", "$3.95", R.drawable.vanilla_latte),
            new MenuModel("HOT CHOCOLATE", "$2.50", "$3.35", "$3.85", R.drawable.hot_chocolate),
            new MenuModel("CARAMEL LATTE", "$2.50", "$3.35", "$3.95", R.drawable.caramel_latte),
            new MenuModel("FLAT WHITE", "$2.50", "$3.35", "$3.85", R.drawable.flat_white),
            new MenuModel("PALM CAPPUCCINO", "$2.75", "$3.50", "$3.95", R.drawable.palm_cappuccino),
            new MenuModel("CAPPUCCINO", "$2.40", "$3.35", "$3.85", R.drawable.cappuccino),
            new MenuModel("CAFFE MOCHA", "$2.75", "$3.50", "$3.95", R.drawable.caffe_mocha),
            new MenuModel("CAFFE LATTE", "$2.40", "$3.35", "$3.85", R.drawable.caffe_latte),
            new MenuModel("AMERICANO", "$2.20", "$3.00", "$3.65", R.drawable.americano),
            new MenuModel("CONDENSE MILK COFFEE", "$2.20", "$3.15", "$3.75", R.drawable.condense_milk_coffee),
            new MenuModel("GREEN TEA LATTE", "$2.70", "$3.45", "$3.95", R.drawable.green_tea_latte),
            new MenuModel("CARAMEL MACCHIATO", "$2.70", "$3.45", "$3.95", R.drawable.caramel_macchiato),
            new MenuModel("ESPRESSO", "$1.85", "", "", R.drawable.espresso)



    ));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot_drink, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }


}
