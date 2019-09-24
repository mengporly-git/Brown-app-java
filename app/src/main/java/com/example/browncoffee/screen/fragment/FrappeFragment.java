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

public class FrappeFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("MOCHA CHIP CREME", "$2.95", "$3.95", "$4.25", R.drawable.mocha_chip_creme),
            new MenuModel("MOCHA FRAPPE", "$2.95", "$3.95", "$4.25", R.drawable.mocha_frappe),
            new MenuModel("OREO GREEN T", "$2.95", "$3.95", "$4.25", R.drawable.oreo_green_t),
            new MenuModel("PALM AND COOKIES", "$2.95", "$3.95", "$4.25", R.drawable.palm_and_cookies),
            new MenuModel("SOYA VANILLA STRAWBERRY FRAPPE", "$2.95", "$3.95", "$4.25", R.drawable.soya_vanilla_strawberry_frappe),
            new MenuModel("CARAMEL FRAPPE", "$2.95", "$3.95", "$4.25", R.drawable.caramel_frappe),
            new MenuModel("CARAMEL MACHHIATO FRAPPE", "$2.95", "$3.95", "$4.25", R.drawable.caramel_machiato_frappe),
            new MenuModel("GATO-VANILLA", "$2.95", "$3.95", "$4.25", R.drawable.gato_vanilla),
            new MenuModel("COFFEE FRAPPE", "$2.95", "$3.95", "$4.25", R.drawable.coffee_frappe),
            new MenuModel("VANILLA FRAPPE", "$2.95", "$3.95", "$4.25", R.drawable.vanilla_frappe),
            new MenuModel("CHOCOLATE FRAPPE", "$2.95", "$3.95", "$4.25", R.drawable.chocolate_frappe),
            new MenuModel("BROWN FRAPPE (COFFEE)", "$2.95", "$3.95", "$4.25", R.drawable.brown_frappe),
            new MenuModel("PALM ESPRESSO", "$2.95", "$3.95", "$4.25", R.drawable.palm_espresso),
            new MenuModel("BROWN DELIGHT (COFFEE)", "$2.95", "$3.95", "$4.25", R.drawable.brown_delight),
            new MenuModel("GREEN TEA FRAPPE", "$2.95", "$3.95", "$4.25", R.drawable.green_tea_frappe)


    ));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frappe, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
